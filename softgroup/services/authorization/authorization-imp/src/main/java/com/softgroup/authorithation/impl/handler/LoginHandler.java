package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.util.ResponseBuilder;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginHandler<T extends LoginRequest, R extends LoginResponse>
        extends AbstractRequestHandler<T, R> implements AuthorizationRequestHandler {

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public T convertData(Request<?> msg) {
        return super.convertData(msg);
    }

    @Override
    public Response<?> handle(Request<?> msg) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setData(convertData(msg));
        ResponseBuilder builder = new ResponseBuilder(msg);

        Response<LoginResponse> response = builder
                .withData(loginResponse)
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
