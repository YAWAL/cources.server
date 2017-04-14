package com.softgroup.token.service.api;


public interface TokenManager {

    String createLongTermToken(String deviceId, String userId);

    boolean validateToken(String token, TokenType tokenType);

    String createShortTermToken(String longTermToken);

}
