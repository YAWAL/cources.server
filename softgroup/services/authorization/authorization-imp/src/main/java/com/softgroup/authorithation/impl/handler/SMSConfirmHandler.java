package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.SMSConfirmRequest;
import com.softgroup.authorization.api.message.SMSConfirmResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class SMSConfirmHandler<T extends SMSConfirmRequest, R extends SMSConfirmResponse>
        extends AbstractRequestHandler<T, R> implements AuthorizationRequestHandler {

    @Override
    public String getName() {
        return "SMS confirm";
    }

    @Override
    public Response<?> handle(Request<?> msg) {
        return super.handle(msg);
    }

}
