package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.DTO.AbrigoDTO;
import br.com.alura.adopet.api.DTO.CadastroAbrigoDTO;
import br.com.alura.adopet.api.DTO.PetDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository repository;

    @Autowired
    private PetRepository petRepository;

    public List<AbrigoDTO> listar() {
        return repository
                .findAll()
                .stream()
                .map(AbrigoDTO::new)
                .collect(Collectors.toList());
    }

    public void cadastrar(@RequestBody @Valid CadastroAbrigoDTO dto) {
        boolean jaCadastrado = repository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email());

        if (jaCadastrado) {
            throw new ValidacaoException("Dados já cadastrados para outro abrigo!");
        } else {
            repository.save(new Abrigo(dto));
        }
    }

    public List<PetDTO> listarPets(@PathVariable String idOuNome) {
        Abrigo abrigo = carregarAbrigo(idOuNome);

        return petRepository
                .findByAbrigo(abrigo)
                .stream()
                .map(PetDTO::new)
                .collect(Collectors.toList());
    }

    public Abrigo carregarAbrigo(String idOuNome) {
        Optional<Abrigo> optional;
        try {
            Long id = Long.parseLong(idOuNome);
            optional = repository.findById(id);
        } catch (NumberFormatException exception) {
            optional = Optional.ofNullable(repository.findByNome(idOuNome));
        }

        return optional.orElseThrow(() -> new ValidacaoException("Abrigo não encontrado"));
    }
}
