package com.softgroup.common.router.api;


import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseData;

public abstract class AbstractRequestHandler<T extends RequestData, R extends ResponseData>
		extends AbstractHandlerFactory implements RequestHandler {

	@Override
	public abstract String getName();

	@Override
	public abstract Response<?> handle(Request<?> msg);
}
