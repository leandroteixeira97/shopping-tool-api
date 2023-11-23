package br.com.api.shoppingtool.service;

import br.com.api.shoppingtool.model.entity.Credential;
import br.com.api.shoppingtool.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CredentialService {

    @Autowired
    private CredentialRepository credentialRepository;

    public CredentialService() {
    }

    public void registerCredential(Credential credential) {
        credentialRepository.save(credential);
    }

    public UserDetails findCredentialByUsername(String username) {
        return credentialRepository.findByUsername(username);
    }

    public Optional<Credential> findById(Integer credentialId) {
        return credentialRepository.findById(credentialId);
    }
}
