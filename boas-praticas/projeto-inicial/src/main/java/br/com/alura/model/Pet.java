package br.com.alura.model;

public class Pet {

  private String nome;
  private String tipo;
  private String raca;
  private String cor;
  private Integer idade;
  private Float peso;  

  public Pet(String nome, String tipo, String raca, String cor, Integer idade, Float peso){
    this.nome = nome;
    this.tipo = tipo;
    this.raca = raca;
    this.cor = cor;
    this.idade = idade;
    this.peso = peso;
  }
}
