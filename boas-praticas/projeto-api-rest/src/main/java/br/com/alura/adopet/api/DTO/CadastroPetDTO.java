package br.com.alura.adopet.api.DTO;

import br.com.alura.adopet.api.model.TipoPet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroPetDTO(@NotNull TipoPet tipo, @NotBlank String nome, @NotBlank String raca,
                             @NotNull Integer idade, @NotBlank String cor, @NotNull Float peso) {
}
