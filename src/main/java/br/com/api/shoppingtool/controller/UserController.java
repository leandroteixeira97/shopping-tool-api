package br.com.api.shoppingtool.controller;

import br.com.api.shoppingtool.model.record.RegisterUserDTO;
import br.com.api.shoppingtool.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    @RequestMapping(path = "/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid RegisterUserDTO registerUserDTO) {
        userService.registerUser(registerUserDTO);

        return ResponseEntity.ok("The user was successfully created!");
    }
}
