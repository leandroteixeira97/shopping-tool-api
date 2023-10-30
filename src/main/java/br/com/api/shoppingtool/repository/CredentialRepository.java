package br.com.api.shoppingtool.repository;

import br.com.api.shoppingtool.model.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Integer> {
    public Optional<Credential> findByUsername(String username);
}
