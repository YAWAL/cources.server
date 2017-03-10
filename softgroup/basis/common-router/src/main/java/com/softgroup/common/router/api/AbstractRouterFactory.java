package com.softgroup.common.router.api;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by VYA on 27.02.2017.
 */
public abstract class AbstractRouterFactory implements RouterFactory{

    @Autowired
    List<Handler> handlers;

    //map for storing handlers
    Map<String, Handler> handlerMap;

    @PostConstruct
    public void init(){
        for (Handler handler : handlers){
            handlerMap.put(handler.getName(), handler);
        }
    }


    public Handler getHandler(String key) {
        return handlerMap.get(getRouteKey(key));
    }


    public abstract String getRouteKey(String msg);

}
