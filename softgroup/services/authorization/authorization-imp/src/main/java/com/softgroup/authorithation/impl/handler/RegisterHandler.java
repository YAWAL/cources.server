package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler <T extends RegisterRequest, R extends RegisterResponse>
        extends AbstractRequestHandler<T, R> implements AuthorizationRequestHandler {

    private Class<T> type;
    private DataMapper mapper;

    @Override
    public String getName() {
        return "register";
    }

    @Override
    public Response<?> handle(Request<?> msg) {

        //convertation : Request<?> msg -> Map<String, Object> -> Class<T>type
        T data = mapper.convert(mapper.convertToMap(msg), type);

        Response<RegisterResponse> response = new Response<>();
        RegisterResponse registerResponse = new RegisterResponse();

        //TODO -> setting of UUID , timeout, auth code
        registerResponse.setRegistration_request_uuid("UUID");
        registerResponse.setRegistration_timeout_sec(3);
        registerResponse.setAuth_code("auth code");

        response.setData(registerResponse);
        return response;
    }

    //getKey by cmd
    @Override
    public String getKey(Request msg) {
        return msg.getActionHeader().getCommand();
    }
}
