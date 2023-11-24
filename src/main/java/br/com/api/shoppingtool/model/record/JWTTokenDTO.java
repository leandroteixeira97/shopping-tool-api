package br.com.api.shoppingtool.model.record;

public record JWTTokenDTO(String jwtToken) {

    public JWTTokenDTO(String jwtToken) {
        this.jwtToken = jwtToken;
    }

}
