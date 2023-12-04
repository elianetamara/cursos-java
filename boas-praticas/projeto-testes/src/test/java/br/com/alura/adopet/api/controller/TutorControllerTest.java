package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.service.TutorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@AutoConfigureMockMvc
class TutorControllerTest {

    @MockBean
    private TutorService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Devolver código 200 para cadastro de tutor")
    void cadastrarSemErros() throws Exception {
        //ARRANGE
        String json = """
                {
                    "nome": "Rodrigo",
                    "telefone": "(21)0000-9090",
                    "email": "email@example.com.br"
                }
                """;
        //ACT
        MockHttpServletResponse response = mockMvc.perform(
                post("/tutores")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();
        //ASSERT
        assertEquals(200,response.getStatus());
    }


    @Test
    @DisplayName("Devolver código 400 para cadastro de tutor")
    void cadastrarComErros() throws Exception {
        //ARRANGE
        String json = """
                {
                    "nome": "Rodrigo",
                    "telefone": "(21)0000-90900",
                    "email": "email@example.com.br"
                }
                """;
        //ACT
        MockHttpServletResponse response = mockMvc.perform(
                post("/tutores")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();
        //ASSERT
        assertEquals(400,response.getStatus());
    }

    @Test
    @DisplayName("Devolver código 200 para atualização de tutor")
    void atualizarSemErros() throws Exception {
        //ARRANGE
        String json = """
                {
                    "id" : "1",
                    "nome": "Rodrigo",
                    "telefone": "(21)0000-9090",
                    "email": "email@example.com"
                }
                """;
        //ACT
        MockHttpServletResponse response = mockMvc.perform(
                put("/tutores")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();
        //ASSERT
        assertEquals(200,response.getStatus());
    }

    @Test
    @DisplayName("Devolver código 400 para atualização de tutor")
    void atualizarComErros() throws Exception {
        //ARRANGE
        String json = """
                {
                    "id" : "1",
                    "nome": "Rodrigo",
                    "telefone": "(21)0000-90900",
                    "email": "email@example.com"
                }
                """;
        //ACT
        MockHttpServletResponse response = mockMvc.perform(
                put("/tutores")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();
        //ASSERT
        assertEquals(200,response.getStatus());
    }

}