package br.com.api.shoppingtool.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateUserDTO(
        @NotNull
        Integer id, String name, String email) {
}
