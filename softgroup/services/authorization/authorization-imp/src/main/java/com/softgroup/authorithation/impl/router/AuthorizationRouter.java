package com.softgroup.authorithation.impl.router;

import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.authorization.api.router.AuthorizationRouterHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.AbstractRouterHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationRouter<T extends AuthorizationRequestHandler> extends AbstractRouterHandler<T>
        implements AuthorizationRouterHandler {

    @Override
    public String getRouteKey(Request<?> msg) {
        return msg.getActionHeader().getCommand();
    }

    public String getName() {
        return "authorization";
    }



}
