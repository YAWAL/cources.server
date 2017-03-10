package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.RequestData;

/**
 * Created by VYA on 24.02.17.
 */
public class SMSConfirmRequest implements RequestData {

    private static final long serialVersionUID = 16282141842368961L;

    private String auth_code;

    private String registration_request_uuid;

    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }

    public String getRegistration_request_uuid() {
        return registration_request_uuid;
    }

    public void setRegistration_request_uuid(String registration_request_uuid) {
        this.registration_request_uuid = registration_request_uuid;
    }

}
