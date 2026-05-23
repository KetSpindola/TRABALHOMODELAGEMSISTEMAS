package Trabalho;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void cabecalhoInicial(){
        System.out.println("                              Olá! Seja bem vindo ao meu código!\n");
        System.out.println("------------------------------------------------------------------------------------------------|");
        System.out.println("- Desenvolvedora: Ketlin B Spindola");
        System.out.println("- Linguagem: Java - Nível inicial.");
        System.out.println("- Possui estrutura e lógica POO de nível básico. (Programação Orientada a Objetos)");
        System.out.println("- Esse código oferece a possibilidade de jogar um jogo da forca com palavras pré definidas.");
        System.out.println("------------------------------------------------------------------------------------------------|");
    }

    public static int menu_inicial(){
        System.out.println("-----------------------------------------------|");
        System.out.println("        Jogo da forca - Menu de Opções");
        System.out.println("0 - Encerrar código (histórico perdido).");
        System.out.println("1 - Jogar jogo.");
        System.out.println("2 - Manual do jogo.");
        System.out.println("3 - Verificar histórico.");
        System.out.println("-----------------------------------------------|");
        System.out.print("Escolha uma opção: ");
        return scan.nextInt();

    }

    public static void main(String[] args) {
        cabecalhoInicial();
        System.out.println("Informe o seu nick de jogador: ");
        String nomeJogador = scan.next();
        while(true) {
            switch (menu_inicial()) {
                case 0:
                    System.out.println("Você escolheu a opção 0 - Sair.");
                    System.out.println("-------------------------------|");
                    System.out.println("Obrigada pela visita!");
                    System.out.println("Encerrando o programa...");
                    return;
                case 1:
                    String teste = "teste";
                    String teste1 = "teste1";
                    Jogo jogoDaForca = new JogoDaForca(teste,teste1);
                    System.out.println("Você escolheu a opção  - Jogar.");
                    System.out.println("-------------------------------|");

            }
        }



    }
}
