package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.util.ResponseBuilder;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler <T extends RegisterRequest, R extends RegisterResponse>
        extends AbstractRequestHandler<T, R> implements AuthorizationRequestHandler {

    @Override
    public String getName() {
        return "register";
    }

    @Override
    public T convertData(Request<?> msg) {
        return super.convertData(msg);
    }

    @Override
    public Response<?> handle(Request<?> msg) {
      T data = convertData(msg);
      RegisterResponse registerResponse = new RegisterResponse();
      registerResponse.setData(data);

     ResponseBuilder builder = new ResponseBuilder(msg);
     Response<RegisterResponse> response = builder
             .withData(registerResponse)
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
