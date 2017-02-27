package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * Created by VYA on 27.02.2017.
 */
public abstract class AbstractHandlerFactory<T extends Handler> implements HandlerFactory {

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

    @Override
    public Handler getHandler(String key) {
        return handlerMap.get(key);
    }

    //method for implementation in any concrete realization which extends  AbstractHandlerFactory
    public abstract Handler getKey(Request msg);

}
