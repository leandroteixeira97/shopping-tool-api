package br.com.api.shoppingtool.service;

import br.com.api.shoppingtool.model.entity.Credential;
import br.com.api.shoppingtool.model.record.RegisterUserDTO;
import br.com.api.shoppingtool.model.entity.User;
import br.com.api.shoppingtool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        Optional<Credential> optionalCredential = credentialService.findCredentialByUsername(registerUserDTO.username());

        Credential credential;

        if (optionalCredential.isEmpty()) {
            credential = new Credential(registerUserDTO);
            credentialService.registerCredential(credential);
        } else {
            credential = optionalCredential.get();
        }

        Optional<User> optionalUser = userRepository.findByCredentialId(credential.getId());

        if (optionalUser.isEmpty()) {
            User userToPersist = new User(registerUserDTO);
            userToPersist.setCredentialId(credential.getId());

            return userRepository.save(userToPersist);
        }

        throw new RuntimeException("A valid user with the given credentials already exists!");
    }

}
