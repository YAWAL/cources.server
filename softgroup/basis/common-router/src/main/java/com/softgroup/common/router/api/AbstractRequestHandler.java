package com.softgroup.common.router.api;


import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.router.api.com.softgroup.common.router.util.AbstractHandlerFactory;

public abstract class AbstractRequestHandler<T extends RequestData, R extends ResponseData>
		extends AbstractHandlerFactory implements RequestHandler {

	private Class<T> type;
	private DataMapper mapper;

	@Override
	public abstract String getName();

	public abstract Response<?> handle(Request<?> msg);

	//convertation : Request<?> msg -> Map<String, Object> -> Class<T>type
	public T convertData(Request<?> msg){
		return mapper.convert(mapper.convertToMap(msg), type);
	}

}
