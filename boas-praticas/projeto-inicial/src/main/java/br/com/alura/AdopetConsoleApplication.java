package br.com.alura;

import br.com.alura.command.CadastraAbrigoCommand;
import br.com.alura.command.CommandExecutor;
import br.com.alura.command.ImportaPetsCommand;
import br.com.alura.command.ListaPetsCommand;
import br.com.alura.command.ListaAbrigoCommand;

import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutor();
        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
        try {
            int opcaoEscolhida = 0;
            while (opcaoEscolhida != 5) {
                menu();
                String textoDigitado = new Scanner(System.in).nextLine();
                opcaoEscolhida = Integer.parseInt(textoDigitado);

                switch (opcaoEscolhida) {
                    case 1 -> executor.executeCommand(new ListaAbrigoCommand());
                    case 2 -> executor.executeCommand(new CadastraAbrigoCommand());
                    case 3 -> executor.executeCommand(new ListaPetsCommand());
                    case 4 -> executor.executeCommand(new ImportaPetsCommand());
                    case 5 -> System.exit(0);
                    default -> opcaoEscolhida = 0;
                }
            }
            System.out.println("Finalizando o programa...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void menu() {
        System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:" +
                "\n1 -> Listar abrigos cadastrados" +
                "\n2 -> Cadastrar novo abrigo" +
                "\n3 -> Listar pets do abrigo" +
                "\n4 -> Importar pets do abrigo" +
                "\n5 -> Sair");
    }
}