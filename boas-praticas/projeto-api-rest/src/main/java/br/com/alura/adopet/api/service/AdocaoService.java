package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.DTO.*;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.*;
import br.com.alura.adopet.api.repository.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AdocaoService {

    @Autowired
    private AdocaoRepository repository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private EmailService emailService;

    public void solicitar(@RequestBody @Valid SolicitacaoAdocaoDTO dto) {
        Pet pet = petRepository.getReferenceById(dto.idPet());
        Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());

       //validacoes

        Adocao adocao = new Adocao();
        adocao.setData(LocalDateTime.now());
        adocao.setStatus(StatusAdocao.AGUARDANDO_AVALIACAO);
        adocao.setPet(pet);
        adocao.setTutor(tutor);
        adocao.setMotivo(dto.motivo());
        repository.save(adocao);

        String message = "Olá " + pet.getAbrigo().getNome() +"!\n\nUma solicitação de adoção foi registrada hoje para o pet: " + pet.getNome() +". \nFavor avaliar para aprovação ou reprovação.";
        emailService.enviarEmail(pet.getAbrigo().getEmail(), "Solicitação de adoção", message);
    }

    public void aprovar(@RequestBody @Valid AprovacaoAdocaoDTO dto) {
        Adocao adocao = repository.getReferenceById(dto.idAdocao());
        adocao.setStatus(StatusAdocao.APROVADO);

        String message = "Parabéns " +adocao.getTutor().getNome() +"!\n\nSua adoção do pet " +adocao.getPet().getNome() +", solicitada em " +adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +", foi aprovada.\nFavor entrar em contato com o abrigo " +adocao.getPet().getAbrigo().getNome() +" para agendar a busca do seu pet.";
        emailService.enviarEmail(adocao.getTutor().getEmail(), "Adoção aprovada", message);
    }

    public void reprovar(@RequestBody @Valid ReprovacaoAdocaoDTO dto) {
        Adocao adocao = repository.getReferenceById(dto.idAdocao());
        adocao.setStatus(StatusAdocao.REPROVADO);
        adocao.setJustificativaStatus(dto.justificativa());

        String message = "Olá " +adocao.getTutor().getNome() +"!\n\nInfelizmente sua adoção do pet " +adocao.getPet().getNome() +", solicitada em " +adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +", foi reprovada pelo abrigo " +adocao.getPet().getAbrigo().getNome() +" com a seguinte justificativa: " +adocao.getJustificativaStatus();
        emailService.enviarEmail(adocao.getTutor().getEmail(), "Adoção reprovada", message);
    }

}
