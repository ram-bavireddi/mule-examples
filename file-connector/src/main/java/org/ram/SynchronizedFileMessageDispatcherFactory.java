package org.ram;

import org.mule.api.MuleException;
import org.mule.api.endpoint.OutboundEndpoint;
import org.mule.api.transport.MessageDispatcher;
import org.mule.transport.AbstractMessageDispatcherFactory;

public class SynchronizedFileMessageDispatcherFactory extends AbstractMessageDispatcherFactory {

	@Override
	public MessageDispatcher create(OutboundEndpoint endpoint) throws MuleException {
		return new SynchronizedFileMessageDispatcher(endpoint);
	}

}
