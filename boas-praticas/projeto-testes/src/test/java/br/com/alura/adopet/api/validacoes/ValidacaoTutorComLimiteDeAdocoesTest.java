package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidacaoTutorComLimiteDeAdocoesTest {

    @InjectMocks
    private ValidacaoTutorComLimiteDeAdocoes validacao;

    @Mock
    private AdocaoRepository adocaoRepository;

    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    @DisplayName("Autoriza solicitação de tutor")
    void validaSolicitacao() {
        // ARRANGE
        BDDMockito.given(adocaoRepository.countAdocaoByTutorIdAndStatus(dto.idTutor(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(4);
        //ASSERT + ACT
        assertDoesNotThrow(() -> validacao.validar(dto));
    }

    @Test
    @DisplayName("Não autoriza solicitação de tutor")
    void invalidaSolicitacao() {
        // ARRANGE
        BDDMockito.given(adocaoRepository.countAdocaoByTutorIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(5);
        //ASSERT + ACT
        assertThrows(ValidacaoException.class, () -> validacao.validar(dto));
    }

}