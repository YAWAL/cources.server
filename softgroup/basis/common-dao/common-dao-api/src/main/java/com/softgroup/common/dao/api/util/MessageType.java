package com.softgroup.common.dao.api.util;

public enum MessageType {

    TEXT(1),

    VIDEO(2),

    AUDIO(3);

    private int code;

    MessageType(int code) {
        this.code = code;
    }
}
