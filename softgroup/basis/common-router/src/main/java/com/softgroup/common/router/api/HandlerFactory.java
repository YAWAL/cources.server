package com.softgroup.common.router.api;

/**
 * Created by VYA on 27.02.2017.
 */
public interface HandlerFactory<T extends Handler> {

    Handler getHandler(String key);

}
