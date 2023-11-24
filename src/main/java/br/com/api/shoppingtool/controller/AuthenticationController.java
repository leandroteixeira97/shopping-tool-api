package br.com.api.shoppingtool.controller;

import br.com.api.shoppingtool.model.entity.Credential;
import br.com.api.shoppingtool.model.record.CredentialsDTO;
import br.com.api.shoppingtool.model.record.JWTTokenDTO;
import br.com.api.shoppingtool.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<JWTTokenDTO> authenticate(@RequestBody CredentialsDTO credentialsDTO) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(credentialsDTO.username(), credentialsDTO.password());

        Authentication authentication = authenticationManager.authenticate(token);

        String jwtToken = tokenService.generateToken((Credential) authentication.getPrincipal());

        return ResponseEntity.ok(new JWTTokenDTO(jwtToken));
    }
}
