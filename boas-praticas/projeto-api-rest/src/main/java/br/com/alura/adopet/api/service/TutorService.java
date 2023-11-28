package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.DTO.AtualizacaoTutorDTO;
import br.com.alura.adopet.api.DTO.CadastroTutorDTO;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastroTutorDTO dto) {
        boolean jaCadastrado = repository.existsByEmailOrTelefone(dto.email(), dto.telefone());

        if (jaCadastrado) {
            throw  new ValidationException("Dados já cadastrados para outro tutor!");
        } else {
            repository.save(new Tutor(dto));
            return ResponseEntity.ok().build();
        }
    }

    public void atualizar(AtualizacaoTutorDTO dto) {
        Tutor tutor = repository.getReferenceById(dto.id());
        tutor.atualizarDados(dto);
    }
}
