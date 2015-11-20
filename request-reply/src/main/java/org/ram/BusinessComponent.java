package org.ram;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class BusinessComponent implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		throw new BusinessException("business exception occurred");
	}

}
