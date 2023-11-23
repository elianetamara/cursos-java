package br.com.alura.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.model.Pet;

public class PetService{

  private ClientHttpConfiguration client;

  public PetService(ClientHttpConfiguration client) {
    this.client = client;
  }

  public void importaPets() throws IOException, InterruptedException {
    System.out.println("Digite o id ou nome do abrigo:");
    String idOuNome = new Scanner(System.in).nextLine();

    System.out.println("Digite o nome do arquivo CSV:");
    String nomeArquivo = new Scanner(System.in).nextLine();

    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(nomeArquivo));
    } catch (IOException e) {
      System.out.println("Erro ao carregar o arquivo: " + nomeArquivo);
      return;
    }
    String line;
    while ((line = reader.readLine()) != null) {
      String[] campos = line.split(",");
      String tipo = campos[0];
      String nome = campos[1];
      String raca = campos[2];
      int idade = Integer.parseInt(campos[3]);
      String cor = campos[4];
      Float peso = Float.parseFloat(campos[5]);

      Pet pet = new Pet(nome, tipo, raca, cor, idade, peso);

      String uri = "http://localhost:8080/abrigos/" + idOuNome + "/pets";

      HttpResponse<String> response = client.requisicaoPost(uri, pet);
      int statusCode = response.statusCode();
      String responseBody = response.body();
      if (statusCode == 200) {
        System.out.println("Pet cadastrado com sucesso: " + nome);
      } else if (statusCode == 404) {
        System.out.println("Id ou nome do abrigo não encontado!");
        break;
      } else if (statusCode == 400 || statusCode == 500) {
        System.out.println("Erro ao cadastrar o pet: " + nome);
        System.out.println(responseBody);
        break;
      }
    }
    reader.close();
  }

  public void listaPets() throws IOException, InterruptedException {
    System.out.println("Digite o id ou nome do abrigo:");
    String idOuNome = new Scanner(System.in).nextLine();

    String uri = "http://localhost:8080/abrigos/" + idOuNome + "/pets";
    HttpResponse<String> response = client.requisicaoGet(uri);
    int statusCode = response.statusCode();
    if (statusCode == 404 || statusCode == 500) {
      System.out.println("ID ou nome não cadastrado!");
      return;
    }
    String responseBody = response.body();
    Pet[] pets = new ObjectMapper().readValue(responseBody, Pet[].class);
    List<Pet> listaPets = Arrays.stream(pets).toList();
    System.out.println("Pets cadastrados:");
    for (Pet pet: listaPets) {
      long id = pet.getId();
      String tipo = pet.getTipo();
      String nome = pet.getNome();
      String raca = pet.getRaca();
      int idade = pet.getIdade();
      System.out.println(id + " - " + tipo + " - " + nome + " - " + raca + " - " + idade + " ano(s)");
    }
  }

}

