package br.com.api.shoppingtool.repository;

import br.com.api.shoppingtool.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
    public Optional<User> findByCredentialId(Integer credentialId);
    public Optional<User> findByIdAndExpiredFalse(Integer id);
    public List<User> findAllByExpiredFalse();
}
