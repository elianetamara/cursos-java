package br.com.alura.adopet.api.validator;

import br.com.alura.adopet.api.DTO.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LimiteAdocoesTutorValidator implements SolicitacaoAdocaoValidator {

    @Autowired
    private AdocaoRepository adocaoRepository;

    public void validar(SolicitacaoAdocaoDTO dto) {
        int adocoes = adocaoRepository.countAdocaoByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO);
        if (adocoes >= 5) {
            throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!");
        }
    }
}
