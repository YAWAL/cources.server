package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.SMSConfirmRequest;
import com.softgroup.authorization.api.message.SMSConfirmResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
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
    public Response<SMSConfirmResponse> handle(Request<?> msg) {
        Response<SMSConfirmResponse> response = new Response<>();
        //convertation : Request<?> msg -> Map<String, Object> -> Class<T>type
        T data = mapper.convert(mapper.convertToMap(msg), type);

        SMSConfirmResponse smsConfirmResponse = new SMSConfirmResponse();
        //TODO get device token from register responce
        smsConfirmResponse.setDevice_token("device token");
        response.setData(smsConfirmResponse);
        return response;
    }

    //getKey by cmd
    @Override
    public String getKey(Request msg) {
        return msg.getActionHeader().getCommand();
    }
}
