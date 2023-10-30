package br.com.api.shoppingtool.model.record;

import jakarta.validation.constraints.NotBlank;

public record RegisterUserDTO(
        @NotBlank
        String name,
        @NotBlank
        String email,
        @NotBlank
        String username,
        @NotBlank
        String password) {
}
