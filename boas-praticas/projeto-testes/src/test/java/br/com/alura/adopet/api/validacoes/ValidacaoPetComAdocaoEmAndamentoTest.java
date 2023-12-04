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

class ValidacaoPetComAdocaoEmAndamentoTest {

    @InjectMocks
    private ValidacaoPetComAdocaoEmAndamento validacao;

    @Mock
    private AdocaoRepository adocaoRepository;

    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    @DisplayName("Autoriza solicitação de adoção de pet")
    void validaSolicitacao() {
        // ARRANGE
        BDDMockito.given(adocaoRepository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(false);
        //ASSERT + ACT
        assertDoesNotThrow(() -> validacao.validar(dto));
    }

    @Test
    @DisplayName("Não autoriza solicitação de adoção de pet")
    void invalidaSolicitacao() {
        // ARRANGE
        BDDMockito.given(adocaoRepository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(true);
        //ASSERT + ACT
        assertThrows(ValidacaoException.class, () -> validacao.validar(dto));
    }
}