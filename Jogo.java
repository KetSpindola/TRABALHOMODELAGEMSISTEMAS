package Trabalho;

// não é instânciada diretamente, mas pode ser usada como "atributo" para gerar objetos das suas filhas

//CLASSES FILHAS:

// - JOGO DA FORCA
public abstract class Jogo {

    // valor atribuido em cada jogo
    protected int tentativas;
    protected String nomeJogador;

    // construtor vazio
    public Jogo(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }
}
