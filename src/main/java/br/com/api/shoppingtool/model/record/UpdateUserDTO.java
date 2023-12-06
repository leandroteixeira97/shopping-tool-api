package br.com.api.shoppingtool.model.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateUserDTO(
        @NotNull
        Integer id, String name, String email) {
}
