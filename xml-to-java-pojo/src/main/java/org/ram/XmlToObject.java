package org.ram;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class XmlToObject extends AbstractMessageTransformer {

	@SuppressWarnings("unchecked")
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		XStream xstream = new XStream();
		xstream.alias((String) message.getInvocationProperty("rootElement"), Map.class);
		xstream.registerConverter(new MapEntryConverter());
		
		String xmlPayload = null;
		try {
			xmlPayload = message.getPayloadAsString();
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		Map<String, String> extractedMap = (Map<String, String>) xstream.fromXML(xmlPayload);
		message.setPayload(extractedMap);
		return message;
	}

	@SuppressWarnings("rawtypes")
	public static class MapEntryConverter implements Converter {

		public boolean canConvert(Class clazz) {
			return AbstractMap.class.isAssignableFrom(clazz);
		}

		@Override
		public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
			AbstractMap map = (AbstractMap) value;
			for (Object obj : map.entrySet()) {
				Map.Entry entry = (Map.Entry) obj;
				writer.startNode(entry.getKey().toString());
				Object val = entry.getValue();
				if (null != val) {
					writer.setValue(val.toString());
				}
				writer.endNode();
			}
		}

		@Override
		public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
			Map<String, String> map = new HashMap<String, String>();
			while (reader.hasMoreChildren()) {
				reader.moveDown();
				String key = reader.getNodeName(); // nodeName aka element's
				String value = reader.getValue();
				map.put(key, value);
				reader.moveUp();
			}
			return map;
		}
	}
}
