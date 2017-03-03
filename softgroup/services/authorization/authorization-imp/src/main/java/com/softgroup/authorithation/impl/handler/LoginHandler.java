package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginHandler<T extends LoginRequest, R extends LoginResponse>
        extends AbstractRequestHandler<T, R> implements AuthorizationRequestHandler {

    private Class<T> type;
    private DataMapper mapper;

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public Response<LoginResponse> handle(Request<?> msg) {

        //convertation : Request<?> msg -> Map<String, Object> -> Class<T>type
        T data = mapper.convert(mapper.convertToMap(msg), type);

        Response<LoginResponse> response = new Response<>();
        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setToken(data.getDeviceToken());
        response.setData(loginResponse);

        return response;
    }

    //getKey by cmd
    @Override
    public String getKey(Request msg) {
        return msg.getActionHeader().getCommand();
    }
}
