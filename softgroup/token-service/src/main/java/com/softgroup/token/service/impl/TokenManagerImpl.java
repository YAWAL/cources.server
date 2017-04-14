package com.softgroup.token.service.impl;

import com.softgroup.token.service.api.TokenManager;
import com.softgroup.token.service.api.TokenType;
import com.softgroup.token.service.util.JWTUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class TokenManagerImpl implements TokenManager {

    private static final String CLAIM_KEY_DEVICE_ID = "deviceID";
    private static final String CLAIM_KEY_USER_ID = "userID";
    private static final String CLAIM_KEY_TOKEN_TYPE = "token type";

    private JWTUtil jwtUtil;

    public String createLongTermToken(String deviceId, String userId) {

        if   (deviceId == null || deviceId.isEmpty() &&
                userId == null || userId.isEmpty()){
            return null;
        }

        Claims claims = Jwts.claims();
        claims.put(CLAIM_KEY_DEVICE_ID, deviceId);
        claims.put(CLAIM_KEY_USER_ID, userId);
        claims.put(CLAIM_KEY_TOKEN_TYPE, TokenType.LONGTERM);

        jwtUtil.setClaimDate(TokenType.LONGTERM);

        return jwtUtil.buildToken(claims, TokenType.LONGTERM);
    }

    public boolean validateToken(String token, TokenType tokenType) {
        return jwtUtil.isTokenValid(token, tokenType);
    }

    public String createShortTermToken(String longTermToken) {

        Claims claims = jwtUtil.parseClaims(longTermToken, TokenType.LONGTERM);
        claims.put(CLAIM_KEY_TOKEN_TYPE, TokenType.SHORTTERM);

        jwtUtil.setClaimDate(TokenType.SHORTTERM);

        return jwtUtil.buildToken(claims, TokenType.SHORTTERM);
    }
}
