package br.com.alura.command;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.AbrigoService;

public class ListaAbrigoCommand implements Command {

  @Override
  public void execute() {
    try {
      ClientHttpConfiguration client = new ClientHttpConfiguration();
      AbrigoService abrigoService = new AbrigoService(client);
      abrigoService.listaAbrigo();
    } catch (Exception e) {
    System.out.println(e.getMessage());;
    }
  }

}
