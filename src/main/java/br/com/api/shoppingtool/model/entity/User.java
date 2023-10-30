package br.com.api.shoppingtool.model.entity;

import br.com.api.shoppingtool.model.record.RegisterUserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity(name = "User")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotNull
    @Column(name = "credential_id")
    private Integer credentialId;

    public User() {}

    public User(Integer id, String name, String email, Integer credentialId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.credentialId = credentialId;
    }

    public User(RegisterUserDTO registerUserDTO) {
        this.name = registerUserDTO.name();
        this.email = registerUserDTO.email();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }
}
