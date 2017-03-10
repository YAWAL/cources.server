package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.SMSConfirmRequest;
import com.softgroup.authorization.api.message.SMSConfirmResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.util.ResponseBuilder;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class SMSConfirmHandler<T extends SMSConfirmRequest, R extends SMSConfirmResponse>
        extends AbstractRequestHandler<T, R> implements AuthorizationRequestHandler {

    private Class<T> type;
    private DataMapper mapper;
    RegisterHandler registerHandler;

    @Override
    public String getName() {
        return "SMS confirm";
    }

    @Override
    public Response<?> handle(Request<?> msg) {
        T data = convertData(msg);
        SMSConfirmResponse smsConfirmResponse = new SMSConfirmResponse();
        smsConfirmResponse.setData(data);

        ResponseBuilder builder = new ResponseBuilder(msg);
        Response<SMSConfirmResponse> response = builder
                .withData(smsConfirmResponse)
                .withCode(200)
                .withMessage("OK")
                .build();
        return response;
    }

    //getKey by cmd
    @Override
    public String getKey(Request msg) {
        return msg.getActionHeader().getCommand();
    }
}
