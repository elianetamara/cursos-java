package br.com.alura.adopet.api.validator;

import br.com.alura.adopet.api.DTO.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetComAdocaoAndamentoValidator implements SolicitacaoAdocaoValidator {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private AdocaoRepository adocaoRepository;

    public void validar(SolicitacaoAdocaoDTO dto) {
        Pet pet = petRepository.getReferenceById(dto.idPet());
        List<Adocao> adocoes = adocaoRepository.findAll();
        for (Adocao a : adocoes) {
            if (a.getPet() == pet && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
                throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
            }
        }
    }
}
