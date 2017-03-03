package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * Created by VYA on 27.02.2017.
 */
public abstract class AbstractHandlerFactory<T extends Handler> implements HandlerFactory {

    @Autowired
    private List<Handler> handlers;

    //map for storing handlers
    private Map<String, Handler> handlerMap;

    @PostConstruct
    public void init(){
        for (Handler handler : handlers){
            handlerMap.put(handler.getName(), handler);
        }
    }

    @Override
    public Handler getHandler(Request msg) {
        return handlerMap.get(getKey(msg));
    }

    //method for implementation in any concrete realization which extends  AbstractHandlerFactory
    public abstract String getKey(Request msg);

}
