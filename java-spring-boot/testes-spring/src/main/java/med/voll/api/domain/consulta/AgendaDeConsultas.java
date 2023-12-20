package med.voll.api.domain.consulta;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados) {
        if (!pacienteRepository.existsById(dados.idPaciente()))
            throw new ValidacaoException("Id do paciente informado não existe!");
        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico()))
            throw new ValidacaoException("Id do médico informado não existe!");
        Paciente paciente = pacienteRepository.findById(dados.idPaciente()).get();
        Medico medico = escolherMedico(dados);
        Consulta consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() != null)
           return medicoRepository.findById(dados.idMedico()).get();
        return null;
    }

}
