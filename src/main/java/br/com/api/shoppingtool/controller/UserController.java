package br.com.api.shoppingtool.controller;

import br.com.api.shoppingtool.model.entity.User;
import br.com.api.shoppingtool.model.record.RegisterUserDTO;
import br.com.api.shoppingtool.model.record.UpdateUserDTO;
import br.com.api.shoppingtool.model.record.UserDTO;
import br.com.api.shoppingtool.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    @RequestMapping(path = "/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody @Valid RegisterUserDTO registerUserDTO) {
        User user = userService.registerUser(registerUserDTO);

        return ResponseEntity.ok(new UserDTO(user));
    }

    @GetMapping
    @RequestMapping(path = "/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable(value = "id") Integer id) {
        User user = userService.findUserById(id);

        UserDTO userDTO = new UserDTO(user);

        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<User> users = userService.findAllUsers();

        List<UserDTO> userDTOs = new ArrayList<>();

        users.forEach(user -> userDTOs.add(new UserDTO(user)));

        return ResponseEntity.ok(userDTOs);
    }

    @PostMapping
    @Transactional
    @RequestMapping(path = "/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody @Valid UpdateUserDTO updateUserDTO) {
        User updatedUser = userService.updateUser(updateUserDTO);

        return ResponseEntity.ok(new UserDTO(updatedUser));
    }

    @DeleteMapping
    @Transactional
    @RequestMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") Integer id) {
        userService.deleteUserById(id);

        return ResponseEntity.ok("The user of ID " + id + " was successfully deleted");
    }
}
