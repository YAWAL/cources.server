package com.softgroup.token.service.util;

import com.softgroup.common.exceptions.ParseTokensClaimsException;
import com.softgroup.token.service.api.TokenType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtil {

    public String buildToken(Claims claims, TokenType tokenType){
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, tokenType.getTokenDescription())
                .compact();
    }

    public Claims parseClaims(String token, TokenType tokenType){
        try {
            return Jwts.parser()
                    .setSigningKey(tokenType.getTokenDescription())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception ex){
            throw new ParseTokensClaimsException("Can not parse token" + ex);
        }
    }

    public void setClaimDate(TokenType tokenType){
        if ("longterm".equals(tokenType.getTokenDescription())){
            generateCurrentDate();
        }
        if ("shortterm".equals(tokenType.getTokenDescription())){
            generateCurrentDate();
            generateExpirationDate();
        }
    }

    private Date generateCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    private Date generateExpirationDate() {
        //30 minutes
        Long shortTokenLiveTime = 1800000L;
        return new Date(System.currentTimeMillis() + shortTokenLiveTime);
    }

    public boolean isTokenValid(String token, TokenType tokenType) {

        Claims claims = parseClaims(token, tokenType);

        boolean isValidByTime = claims.getIssuedAt().before(new Date());
        boolean isValidByType = claims.get("tokenType").equals(tokenType.name());

        return isValidByTime && isValidByType;
    }

}
