package br.com.alura.model;

public class Pet {

  private Long id;
  private String nome;
  private String tipo;
  private String raca;
  private String cor;
  private Integer idade;
  private Float peso;  

  public Pet(){

  }

  public Pet(String nome, String tipo, String raca, String cor, Integer idade, Float peso){
    this.nome = nome;
    this.tipo = tipo;
    this.raca = raca;
    this.cor = cor;
    this.idade = idade;
    this.peso = peso;
  }

  public String getNome() {
    return this.nome;
  }

  public long getId() {
    return this.id;
  }

  public String getTipo() {
    return this.tipo;
  }

  public int getIdade() {
    return this.idade;
  }

  public String getRaca() {
    return this.raca;
  }

  public String getCor(){
    return this.cor;
  }

  public Float getPeso(){
    return this.peso;
  }

}
