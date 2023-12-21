package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemConsulta  implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        boolean pacienteOutraConsulta = consultaRepository.existsByPacienteIdAndDataBetween(dados.idPaciente(), dados.data().withHour(7), dados.data().withHour(18));
        if (pacienteOutraConsulta)
            throw new ValidacaoException("Paciente já possui outra consulta neste dia");
    }
}
