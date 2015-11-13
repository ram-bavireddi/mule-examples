package org.ram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;

public class QueryParamsToList implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage muleMessage = eventContext.getMessage();
		Map<String, String> queryParams = muleMessage.getInboundProperty("http.query.params");
		for (Map.Entry<String, String> entry : queryParams.entrySet()) {
			List<String> propsAsList = Arrays.asList(entry.getValue().split("\\s*,\\s*"));
			Map<String, Object> props = new HashMap<>();
			props.put(entry.getKey(), propsAsList);
			muleMessage.addProperties(props, PropertyScope.INBOUND);
		}
		return muleMessage;
	}
}
