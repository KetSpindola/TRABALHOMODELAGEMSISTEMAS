package Trabalho;

// não é instânciada diretamente, mas pode ser usada como "atributo" para gerar objetos das suas filhas

//CLASSES FILHAS:

// - JOGO DA FORCA
public abstract class Jogo {

    // valor atribuido em cada jogo
    protected int tentativas;

    // construtor vazio
    public Jogo() {
    }

    //padronizar entradas maiusculas
    public String maiuscula(String entrada) { // usada para todas as entradas em padrão
        return entrada.toUpperCase();
    }

}
