package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.ResponseData;

/**
 * Created by VYA on 24.02.17.
 */
public class SMSConfirmResponse implements ResponseData {

    private static final long serialVersionUID = 636717510400790106L;

    private String device_token;

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }

}
