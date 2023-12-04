package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.service.AdocaoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@AutoConfigureMockMvc
class AdocaoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AdocaoService adocaoService;

    @Test
    @DisplayName("Devolver código 400 para solicitação de adoção com erros")
    void solicitaComErros() throws Exception {
        //ARRANGE
        String json = "{}";

        //ACT
        var response = mvc.perform(
                post("/adocoes")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //ASSERT
        assertEquals(400, response.getStatus());
    }

    @Test
    @DisplayName("Devolver código 200 para solicitação de adoção sem erros")
    void solicitaSemErros() throws Exception {
        //ARRANGE
        String json = """
                {
                    "idPet": 1,
                    "idTutor": 1,
                    "motivo": "Motivo qualquer"
                }
                """;

        //ACT
        var response = mvc.perform(
                post("/adocoes")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //ASSERT
        assertEquals(200, response.getStatus());
    }

    @Test
    @DisplayName("Devolver código 200 para aprovação sem erros")
    void aprovaSemErros() throws Exception {
        //ARRANGE
        String json = """
                {
                    "idAdocao": 1
                }
                """;

        //ACT
        MockHttpServletResponse response = mvc.perform(
                put("/adocoes/aprovar")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //ASSERT
        assertEquals(200, response.getStatus());
    }

    @Test
    @DisplayName("Devolver código 400 para aprovação com erros")
    void aprovaComErros() throws Exception {
        //ARRANGE
        String json = """
                {
                    
                }
                """;

        //ACT
        MockHttpServletResponse response = mvc.perform(
                put("/adocoes/aprovar")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //ASSERT
        assertEquals(400, response.getStatus());
    }

    @Test
    @DisplayName("Devolver código 200 para reprovação sem erros")
    void reprovaSemErros() throws Exception {
        //ARRANGE
        String json = """
                {
                    "idAdocao": 1,
                    "justificativa": "qualquer"
                }
                """;

        //ACT
        MockHttpServletResponse response = mvc.perform(
                put("/adocoes/reprovar")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //ASSERT
        assertEquals(200, response.getStatus());
    }

    @Test
    @DisplayName("Devolver código 400 para reprovação com erros")
    void reprovaComErros() throws Exception {
        //ARRANGE
        String json = """
                {

                }
                """;

        //ACT
        MockHttpServletResponse response = mvc.perform(
                put("/adocoes/reprovar")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //ASSERT
        assertEquals(400, response.getStatus());

    }
}