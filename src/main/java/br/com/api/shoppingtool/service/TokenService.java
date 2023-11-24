package br.com.api.shoppingtool.service;

import br.com.api.shoppingtool.model.entity.Credential;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    private final String issuer = "Shopping Tool API";

    public String generateToken(Credential credential) {
        try {

        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.
                create().
                withIssuer(issuer).
                withSubject(credential.getUsername()).
                withExpiresAt(getExpirationDate()).
                sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("An error occurred when trying to generate the JWT Token");
        }

    }

    private Instant getExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String validateJWTToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.
                    require(algorithm).
                    withIssuer(issuer).
                    build().
                    verify(token).
                    getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("The JWT Token is invalid or expired!");
        }
    }

}
