package br.com.alura.adopet.api.DTO;

import br.com.alura.adopet.api.model.Abrigo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AbrigoDTO(@NotNull Long id, @NotBlank String nome) {

    public AbrigoDTO(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome());
    }

}
