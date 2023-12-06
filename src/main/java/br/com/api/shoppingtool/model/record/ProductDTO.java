package br.com.api.shoppingtool.model.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(@NotBlank String name, @NotNull Integer subCategoryId) {
}
