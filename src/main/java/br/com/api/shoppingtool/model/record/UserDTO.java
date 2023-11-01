package br.com.api.shoppingtool.model.record;

import br.com.api.shoppingtool.model.entity.User;

public record UserDTO(Integer id, String name, String email) {
    public UserDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
