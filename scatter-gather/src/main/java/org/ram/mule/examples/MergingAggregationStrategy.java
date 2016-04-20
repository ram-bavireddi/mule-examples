package org.ram.mule.examples;

import java.util.List;

import org.mule.DefaultMessageCollection;
import org.mule.DefaultMuleEvent;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.MuleMessageCollection;
import org.mule.api.context.MuleContextAware;
import org.mule.api.routing.AggregationContext;
import org.mule.routing.AggregationStrategy;

public class MergingAggregationStrategy implements AggregationStrategy, MuleContextAware {

	private MuleContext muleContext;

	@Override
	public MuleEvent aggregate(AggregationContext context) throws MuleException {
		MuleEvent resultEvent = null;
		MuleEvent previous = context.getOriginalEvent();
		MuleMessageCollection coll = new DefaultMessageCollection(muleContext);

		for (MuleEvent event : context.collectEventsWithoutExceptions()) {
			List<?> payload = (List<?>) event.getMessage().getPayload();
			for (Object element : payload) {
				MuleMessage message = new DefaultMuleMessage(element, muleContext);
				coll.addMessage(message);
			}
		}

		resultEvent = new DefaultMuleEvent(coll, previous, previous.getSession());

		for (String name : previous.getFlowVariableNames()) {
			resultEvent.setFlowVariable(name, previous.getFlowVariable(name));
		}
		return resultEvent;
	}

	@Override
	public void setMuleContext(MuleContext context) {
		muleContext = context;
	}
}
