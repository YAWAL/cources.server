package com.softgroup.common.protocol.util;

import com.softgroup.common.protocol.*;

import java.util.UUID;

/**
 * Created by VYA on 07.03.2017.
 */
public class ResponseBuilder<R extends RequestData,T extends ResponseData> {

    private String uuid = UUID.randomUUID().toString();
    private String originUuid;
    private String type;
    private String command;
    private String version = "protocolVersion";

    private T data;

    private Integer code;
    private String message;

    public ResponseBuilder(Request<R> request) {

        originUuid = request.getHeader().getOriginUuid();
        type = request.getHeader().getType();
        command = request.getHeader().getCommand();
    }

    public ResponseBuilder<R,T> withUuid(final String uuid ) {
        this.uuid = uuid;
        return this;
    }

    public ResponseBuilder<R,T> withVersion(final String version ) {
        this.version = version;
        return this;
    }

    public ResponseBuilder<R,T> withData(final T data ) {
        this.data = data;
        return this;
    }

    public ResponseBuilder<R,T> withCode(final Integer code ) {
        this.code = code;
        return this;
    }

    public ResponseBuilder<R,T> withMessage(final String message ) {
        this.message = message;
        return this;
    }

    public Response<T> build() {
        ActionHeader header = new ActionHeader();
        header.setUuid(uuid);
        header.setOriginUuid(originUuid);
        header.setType(type);
        header.setCommand(command);
        header.setVersion(version);

        ResponseStatus status = new ResponseStatus();
        status.setCode(code);
        status.setMessage(message);

        Response<T> response = new Response<T>();
        response.setHeader(header);
        response.setData(data);
        response.setStatus(status);

        return response;
    }
}