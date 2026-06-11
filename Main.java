package Trabalho;

import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void aguardarELimpar() {
        System.out.print("\nPressione enter para continuar...");
        scan.nextLine();
        System.out.println("\n".repeat(50));
    }

    public static void limparTela() {
        System.out.println("\n".repeat(50));
    }

    public static void cabecalhoInicial() {
        limparTela();
        System.out.println("                              Olá! Seja bem vindo ao meu código!");
        System.out.println("------------------------------------------------------------------------------------------------|");
        System.out.println("- Desenvolvedora: Ketlin B Spindola");
        System.out.println("- Linguagem: Java - Nível inicial.");
        System.out.println("- Possui estrutura e lógica POO de nível básico. (Programação Orientada a Objetos)");
        System.out.println("- Esse código oferece a possibilidade de jogar um jogo da forca com palavras pré definidas.");
        System.out.println("------------------------------------------------------------------------------------------------|");
    }

    public static int menuInicial() {
        while (true) {
            try {
                System.out.println("-----------------------------------------------|");
                System.out.println("        Jogo da forca - Menu de Opções");
                System.out.println("0 - Encerrar código.");
                System.out.println("1 - Jogar jogo.");
                System.out.println("2 - Manual do jogo.");
                System.out.println("-----------------------------------------------|");
                System.out.print("Escolha uma opção: ");
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Tente novamente: " + e.getMessage());
                aguardarELimpar();
            }
        }

    }

    public static int menuTentativa() {
        while (true) {
            try {
                System.out.println("---------------------------------------|");
                System.out.println("        Partida - Menu de Opções");
                System.out.println("0 - Voltar ao Menu Principal.");
                System.out.println("1 - Enviar letra.");
                System.out.println("2 - Enviar palpite de palavra.");
                System.out.println("---------------------------------------|");
                System.out.print("Escolha uma opção: ");
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Tente novamente: " + e.getMessage());
                aguardarELimpar();
            }
        }
    }

    public static String validarletra() {
        while (true) {
            System.out.print("Qual letra deseja enviar: ");
            String escolhaUsuario = scan.nextLine();
            if (escolhaUsuario.trim().length() != 1 || !Character.isLetter(escolhaUsuario.charAt(0))) { // nao possui tamanho 1 ou nao é letra
                System.out.println("Tente novamente.");
            } else {
                return escolhaUsuario;
            }
        }
    }

    public static void main(String[] args) {
        cabecalhoInicial(); // apresentação desenvolvimento
        aguardarELimpar();

        // criando objeto para reutilização
        GerenciadorPalavras gerencPalavr = new GerenciadorPalavras("C:\\Users\\ketli\\IdeaProjects\\modelagem\\src\\Trabalhorenovado\\Palavras.txt");

        while (true) { // sair, jogar, manual
            switch (menuInicial()) {
                case 0:
                    limparTela();
                    System.out.println("Você escolheu a opção 0 - Sair.");
                    System.out.println("-------------------------------|");
                    System.out.println("Obrigada pela visita!");
                    System.out.println("Encerrando o programa...");
                    return;

                case 1:
                    aguardarELimpar();
                    System.out.println("Você escolheu a opção 1 - Jogar.");
                    System.out.println("---------------------------------------|");

                    // pegando PALAVRA e DICA aleatório
                    String[] letras = new String[2]; //
                    letras = gerencPalavr.obterPalavraAleatoria();

                    // criando objeto jogo passando PALAVRA e LETRA
                    JogoDaForca jogo = new JogoDaForca(letras[0], letras[1]);

                    jogo.exibirEstadoJogo(); // dica, tentativas disponiveis, jogadas, acertadas, erradas, desenho forca, array

                    // LOOP DA PARTIDA - Menu do Jogo
                    boolean partidaAtiva = true; // true em op 0, vencer, perder e acertar palpite - sai do loop
                    while (partidaAtiva) {

                        switch (menuTentativa()) { // voltar, letra, palpite
                            case 0:
                                System.out.println("Você escolheu a opção 0 - Voltar ao Menu Principal.");
                                System.out.println("--------------------------------------------------|");
                                partidaAtiva = false;
                                aguardarELimpar();
                                break;

                            case 1:
                                // ENVIAR LETRA
                                System.out.println("Você escolheu a opção 1 - Enviar letra.");
                                System.out.println("---------------------------------------|");

                                boolean letraValida = false; // true em nao jogada
                                while (!letraValida) {
                                    String escolhaUsuario = validarletra();

                                    boolean letraJaJogada = jogo.verificarJajogada(escolhaUsuario);

                                    if (letraJaJogada) {
                                        System.out.println("Letra já jogada. Tente outra.");

                                    } else { // valida a letra e inclui nas listas

                                        letraValida = true; // sai do loop

                                        boolean retornoTentativa = jogo.tentativa(escolhaUsuario);

                                        if (retornoTentativa) {
                                            System.out.println("Letra acertada!");
                                        } else {
                                            System.out.println("Letra errada!");
                                        }
                                        // verifica VITORIA, DERROTA - saem da partida
                                        // ou CONTINUA - recebe nova letra ou palpite
                                        String resultado = jogo.verificarResultado();

                                        if (resultado.equals("VITORIA")) {
                                            System.out.println("Parabéns, você VENCEU o jogo!");
                                            aguardarELimpar();
                                            jogo.exibirPlacarFinal(resultado); // dica, tentativas disponiveis, jogadas, acertadas, erradas, desenho forca, array
                                            aguardarELimpar();
                                            partidaAtiva = false;
                                            break;
                                        } else if (resultado.equals("DERROTA")) {
                                            System.out.println("Desculpe, você PERDEU o jogo :/");
                                            aguardarELimpar();
                                            jogo.exibirPlacarFinal(resultado); // dica, tentativas disponiveis, jogadas, acertadas, erradas, desenho forca, array
                                            aguardarELimpar();
                                            partidaAtiva = false;
                                            break;

                                            // se retornar CONTINUE, não dai do loop
                                        } else {
                                            aguardarELimpar();
                                            jogo.exibirEstadoJogo(); // dica, tentativas disponiveis, jogadas, acertadas, erradas, desenho forca, array
                                        }


                                    }

                                }
                                break;

                            case 2:
                                // ENVIAR PALPITE
                                System.out.println("Você escolheu a opção 2 - Enviar palpite.");
                                System.out.println("----------------------------------------|");
                                System.out.print("Qual palavra deseja enviar? ");
                                String palpiteUsu = scan.nextLine();

                                boolean retornoPalpite = jogo.palpitePalavra(palpiteUsu);
                                while (true) {
                                    if (retornoPalpite) {
                                        System.out.println("Você acertou a palavra!");
                                        System.out.println("Parabéns, você VENCEU o jogo!");
                                        aguardarELimpar();
                                        jogo.exibirPlacarFinal("VITORIA"); // dica, tentativas disponiveis, jogadas, acertadas, erradas, desenho forca, array
                                        aguardarELimpar();
                                        partidaAtiva = false; // sai do loop
                                        break;
                                    } else {
                                        System.out.println("Palavra incorreta! Tente novamente na proxima.");
                                        aguardarELimpar();
                                    }
                                }
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                                aguardarELimpar();
                                break;
                        }
                    }
                    // Fim do loop da partida - volta para o menu principal
                    break;

                case 2:
                    // Manual do jogo
                    aguardarELimpar();
                    System.out.println("Você escolheu a opção 2 - Manual do jogo.");
                    System.out.println("------------------------------------------------------------------|");
                    System.out.println("OBJETIVO: Adivinhar a palavra através de letras ou palpites!");
                    System.out.println("REGRAS:");
                    System.out.println("- Tentativas são na mesma quantidade de letras da palavra sorteada");
                    System.out.println("- Somente letras erradas reduzem suas tentativas");
                    System.out.println("- Acerte todas as letras OU dê o palpite correto para ganhar");
                    System.out.println("- Se as tentativas zerarem, você perde");
                    System.out.println("OPCOES DURANTE O JOGO:");
                    System.out.println("- Enviar letra: Tente adivinhar uma letra");
                    System.out.println("- Enviar palpite: Tente adivinhar a palavra inteira");
                    System.out.println("BOA SORTE!");
                    System.out.println("------------------------------------------------------------------|");
                    aguardarELimpar();
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    aguardarELimpar();
                    break;
            }

        }

    }
}
