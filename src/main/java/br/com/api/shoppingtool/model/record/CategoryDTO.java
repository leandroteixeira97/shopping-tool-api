package br.com.api.shoppingtool.model.record;

import jakarta.validation.constraints.NotBlank;

public record CategoryDTO(@NotBlank String name) {
}
