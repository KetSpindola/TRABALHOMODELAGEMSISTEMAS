package JogoDaForca;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void cabecalhoInicial(){
        System.out.println("                              Olá! Seja bem vindo ao meu código!\n");
        System.out.println("================================================================================================|");
        System.out.println("\n- Desenvolvedora: Ketlin B Spindola");
        System.out.println("\n- Linguagem: Java - Nível inicial.");
        System.out.println("\n- Possui estrutura e lógica POO de nível básico. (Programação Orientada a Objetos)");
        System.out.println("\n- Esse código oferece a possibilidade de jogar um jogo da forca com palavras pré definidas.");
        System.out.println("\n================================================================================================|\n");
    }

    public static int menu_inicial(){
        System.out.println("===============================================|");
        System.out.println("        Jogo da forca - Menu de Opções");
        System.out.println("0 - Encerrar código (histórico perdido).");
        System.out.println("1 - Jogar jogo.");
        System.out.println("2 - Manual do jogo.");
        System.out.println("3 - Verificar histórico.");
        System.out.println("===============================================|");
        return scan.nextInt();

    }

    public static void main(String[] args) {

        int resultadoMenu = menu_inicial();

        if (resultadoMenu == 0) {
            System.out.println("Você escolheu encerrar o código. Até mais!!");
        }else if(resultadoMenu == 1){
            System.out.println("Você escolheu jogar o jogo da Forca.");
        }



    }
}
