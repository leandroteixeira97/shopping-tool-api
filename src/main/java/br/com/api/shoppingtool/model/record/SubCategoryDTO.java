package br.com.api.shoppingtool.model.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SubCategoryDTO(@NotBlank String name, @NotNull Integer categoryId) {
}
