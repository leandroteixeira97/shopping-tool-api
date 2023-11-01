package br.com.api.shoppingtool.model.entity;

import br.com.api.shoppingtool.model.record.RegisterUserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity(name = "Credential")
@Table(name = "credential")
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public Credential() {}

    public Credential(Integer id, String username, String password, Integer userId, Boolean expired) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Credential(RegisterUserDTO registerUserDTO) {
        this.username = registerUserDTO.username();
        this.password = registerUserDTO.password();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
