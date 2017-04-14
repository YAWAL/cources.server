package com.softgroup.token.service.api;

/**
 * Created by VYA on 10.04.2017.
 */
public enum TokenType {

    LONGTERM("longterm"),

    SHORTTERM("shortterm");

    private String tokenDescription;

    TokenType(String tokenDescription) {
        this.tokenDescription = tokenDescription;
    }

    public String getTokenDescription() {
        return tokenDescription;
    }
}
