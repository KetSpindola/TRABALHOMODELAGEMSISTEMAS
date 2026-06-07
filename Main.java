package Trabalho;

import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void maiuscula(String entrada) {
    }

    public static void cabecalhoInicial() {
        System.out.println("                              Olá! Seja bem vindo ao meu código!");
        System.out.println("------------------------------------------------------------------------------------------------|");
        System.out.println("- Desenvolvedora: Ketlin B Spindola");
        System.out.println("- Linguagem: Java - Nível inicial.");
        System.out.println("- Possui estrutura e lógica POO de nível básico. (Programação Orientada a Objetos)");
        System.out.println("- Esse código oferece a possibilidade de jogar um jogo da forca com palavras pré definidas.");
        System.out.println("------------------------------------------------------------------------------------------------|");
    }

    public static int menuInicial() {
        System.out.println("-----------------------------------------------|");
        System.out.println("        Jogo da forca - Menu de Opções");
        System.out.println("0 - Encerrar código.");
        System.out.println("1 - Jogar jogo.");
        System.out.println("2 - Manual do jogo.");
        System.out.println("-----------------------------------------------|");
        System.out.print("Escolha uma opção: ");
        return scan.nextInt();

    }

    public static int menuTentativa() {
        System.out.println("            Menu de Opções");
        System.out.println("0 - Encerrar o jogo.");
        System.out.println("1 - Enviar letra.");
        System.out.println("2 - Enviar palpite de palavra.");
        System.out.println("---------------------------------------|");
        System.out.print("Escolha uma opção: ");
        return scan.nextInt();
    }

    public static void main(String[] args) {
        cabecalhoInicial();
        String teste = "teste";
        String teste1 = "teste1";
        JogoDaForca jogo = new JogoDaForca(teste, teste1);

        while (true) {
            switch (menuInicial()) {
                case 0:
                    System.out.println("Você escolheu a opção 0 - Sair.");
                    System.out.println("-------------------------------|");
                    System.out.println("Obrigada pela visita!");
                    System.out.println("Encerrando o programa...");
                    return;

                case 1:
                    // validar tentativa e se o vetor foi descoberto - não deixar mais enviar letras
                    // encerrar com vitória se o vetor foi descoberto, encerrar com derrota se não tem mais tentativas
                    // mostrar nome jogador, jogadas, corretas, erradas, desenho
                    // dar opcao de enviar letra ou dar palpite de palavra
                    // ao receber a letra, validar se ja foi usada, validar se esta no vetor da palavra
                    // retorna se a letra era correta ou incorreta
                    System.out.println("Você escolheu a opção 1 - Jogar.");
                    System.out.println("-------------------------------|");

                    while (true) {
                        switch (menuTentativa()) {
                            case 0:
                                System.out.println("Você escolheu a opção 0 - Encerrar jogo.");
                                System.out.println("---------------------------------|");
                                return;
                            case 1:
                                while (true) {
                                    System.out.println("Você escolheu a opção 1 - Enviar letra.");
                                    System.out.println("---------------------------------------|");
                                    System.out.print("Qual letra deseja enviar? ");
                                    String letraUsu = scan.next();

                                    boolean letraJaJogada = jogo.verificarJajogada(letraUsu); //retorna true se ja foi jogada
                                    if (letraJaJogada) {
                                        //LETRA JA JOGADA, TENTAR NOVAMENTE
                                        System.out.println("Letra ja jogada, tente outra.");

                                    } else {

                                        boolean retornoTentativa = jogo.tentativa(letraUsu);
                                        if (retornoTentativa) {
                                            System.out.println("Letra acertada!");
                                            //LETRA ACERTADA
                                        } else {
                                            System.out.println("Letra errada!");
                                            //LETRA ERRADA
                                        }

                                        boolean retornoTentativas = jogo.verificadorTentativas();
                                        if (retornoTentativas) {
                                            System.out.println("Jogo encerrado por falta de tentativas. Derrota!");
                                            return;
                                        } else {
                                            boolean retornoDescobertaTotal = jogo.verificarVitoria();
                                            if (retornoDescobertaTotal) {
                                                System.out.println("Acertou todas as letras. Vitória!");
                                            }

                                        }

                                        return;
                                    }
                                }

                            case 2:
                                System.out.println("Você escolheu a opção 2 - Enviar palpite.");
                                System.out.println("----------------------------------------|");
                                System.out.print("Qual palavra deseja enviar? ");
                                String palpiteUsu = scan.next();

                                boolean retornoPalpite = jogo.palpitePalavra(palpiteUsu);//retorna true se a palavra for igual
                                if (retornoPalpite) {
                                    System.out.println("Você acertou!");
                                    //JOGO VENCIDO, ENCERRAR
                                } else {
                                    System.out.println("Você errou!");
                                    //JOGO CONTINUA - COLOCAR LIMITE DE PALPITE?
                                }
                        }
                    }
            }


        }


    }
}
