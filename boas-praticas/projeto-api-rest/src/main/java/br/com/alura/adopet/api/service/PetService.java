package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.DTO.PetDTO;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public List<PetDTO> buscaDisponiveis() {
        return repository
                .findAllByAdotadoFalse()
                .stream()
                .map(PetDTO::new)
                .collect(Collectors.toList());
    }

    /*public void cadastrarPet(Abrigo abrigo, CadastroPetDTO dto) {
        repository.save(new Pet(dto, abrigo));
    }*/
}
