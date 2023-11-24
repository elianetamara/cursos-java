package br.com.alura.command;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.PetService;

public class ImportaPetsCommand implements Command {

  @Override
  public void execute() {
    ClientHttpConfiguration client = new ClientHttpConfiguration();
    PetService petService = new PetService(client);
    try {
      petService.importaPets();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
