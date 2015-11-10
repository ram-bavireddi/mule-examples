package org.ram;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.mule.DefaultMuleMessage;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.endpoint.OutboundEndpoint;
import org.mule.api.transport.OutputHandler;
import org.mule.transformer.types.DataTypeFactory;
import org.mule.transport.AbstractMessageDispatcher;
import org.mule.transport.NullPayload;
import org.mule.transport.file.FileConnector;
import org.mule.util.IOUtils;
import org.mule.util.StringUtils;

public class SynchronizedFileMessageDispatcher extends AbstractMessageDispatcher {

	private final FileConnector connector;

	public SynchronizedFileMessageDispatcher(OutboundEndpoint endpoint) {
		super(endpoint);
		this.connector = (FileConnector) endpoint.getConnector();

		if (endpoint.getProperty("outputAppend") != null) {
			throw new IllegalArgumentException(
					"Configuring 'outputAppend' on a file endpoint is no longer supported. You may configure it on a file connector instead.");
		}
	}

	@Override
	protected synchronized void doDispatch(MuleEvent event) throws Exception {
		Object data = event.getMessage().getPayload();
		// Wrap the transformed message before passing it to the filename parser
		MuleMessage message = new DefaultMuleMessage(data, event.getMessage(), event.getMuleContext());
		FileOutputStream fos = (FileOutputStream) connector.getOutputStream(getEndpoint(), event);
		try {
			if (event.getMessage().getOutboundProperty(FileConnector.PROPERTY_FILENAME) == null) {
				event.getMessage().setOutboundProperty(FileConnector.PROPERTY_FILENAME,
						message.getOutboundProperty(FileConnector.PROPERTY_FILENAME, StringUtils.EMPTY));
			}
			if (data instanceof byte[]) {
				fos.write((byte[]) data);
			} else if (data instanceof String) {
				fos.write(data.toString().getBytes(event.getEncoding()));
			} else if (data instanceof OutputHandler) {
				((OutputHandler) data).write(event, fos);
			} else {
				InputStream is = event.transformMessage(DataTypeFactory.create(InputStream.class));
				IOUtils.copyLarge(is, fos);
				is.close();
			}
		} finally {
			logger.debug("Closing file");
			fos.close();
		}
	}

	@Override
	protected MuleMessage doSend(MuleEvent event) throws Exception {
		doDispatch(event);
		return new DefaultMuleMessage(NullPayload.getInstance(), getEndpoint().getMuleContext());
	}
}
