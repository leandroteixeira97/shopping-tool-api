package br.com.api.shoppingtool.service;

import br.com.api.shoppingtool.controller.UpdateUserDTO;
import br.com.api.shoppingtool.model.entity.Credential;
import br.com.api.shoppingtool.model.exception.ResourceNotFoundException;
import br.com.api.shoppingtool.model.record.RegisterUserDTO;
import br.com.api.shoppingtool.model.entity.User;
import br.com.api.shoppingtool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CredentialService credentialService;

    public UserService() {
    }

    public User registerUser(RegisterUserDTO registerUserDTO) throws RuntimeException {

        UserDetails optionalCredential = credentialService.findCredentialByUsername(registerUserDTO.username());

        Credential credential;

        if (optionalCredential == null) {
            credential = new Credential(registerUserDTO);
            credentialService.registerCredential(credential);
        } else {
            credential = (Credential) optionalCredential;
        }

        Optional<User> optionalUser = userRepository.findByCredentialId(credential.getId());

        if (optionalUser.isEmpty()) {
            User userToPersist = new User(registerUserDTO);
            userToPersist.setCredentialId(credential.getId());

            return userRepository.save(userToPersist);
        }

        throw new RuntimeException("A valid user with the given credentials already exists!");
    }

    public List<User> findAllUsers() {
        return userRepository.findAllByExpiredFalse();
    }

    public User findUserById(Integer id) {
        Optional<User> optionalUser = userRepository.findByIdAndExpiredFalse(id);

        if (optionalUser.isEmpty()) throw new ResourceNotFoundException("No user was found to the given ID: " + id);

        return optionalUser.get();
    }

    public User updateUser(UpdateUserDTO updateUserDTO) {
        User user = this.findUserById(updateUserDTO.id());

        if (updateUserDTO.name() != null && !updateUserDTO.name().isEmpty()) user.setName(updateUserDTO.name());
        if (updateUserDTO.email() != null && !updateUserDTO.email().isEmpty()) user.setEmail(updateUserDTO.email());

        return user;
    }

    public void deleteUserById(Integer id) {
        User user = this.findUserById(id);

        user.setExpired(true);
    }
}
