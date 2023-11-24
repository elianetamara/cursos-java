package br.com.alura.command;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.PetService;

public class ListaPetsCommand implements Command {

  @Override
  public void execute() {
    ClientHttpConfiguration client = new ClientHttpConfiguration();
    PetService petService = new PetService(client);
    try {
      petService.listaPets();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
