package br.com.alura.model;

public class Abrigo {

  private Long id;
  private String nome;
  private String telefone;
  private String email;
  private Pet[] pets;

  public Abrigo(){

  }

  public Abrigo(String nome, String telefone, String email) {
    this.telefone = telefone;
    this.email = email;
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

  public long getId() {
    return this.id;
  }

  public String getTelefone() {
    return this.telefone;
  }

  public String getEmail() {
    return this.email;
  }

  public Pet[] getPets() {
    return this.pets;
  }

}
