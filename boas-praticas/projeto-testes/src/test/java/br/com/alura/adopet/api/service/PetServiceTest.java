package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.BDDMockito.then;

class PetServiceTest {

    @InjectMocks
    private PetService service;

    @Mock
    private CadastroPetDto cadastroPetDto;

    @Mock
    private PetRepository repository;

    @Mock
    private Abrigo abrigo;

    @Test
    @DisplayName("Busca todos os pets disponíveis")
    void buscarPetsDisponiveis() {
        //ACT
        service.buscarPetsDisponiveis();
        //ASSERT
        then(repository).should().findAllByAdotadoFalse();
    }

    @Test
    @DisplayName("")
    void cadastrarPet() {
        //ACT
        service.cadastrarPet(abrigo,cadastroPetDto);
        //ASSERT
        then(repository).should().save(new Pet(cadastroPetDto,abrigo));
    }
}