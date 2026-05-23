package Trabalho;

import java.util.ArrayList;
import java.util.Arrays;

//OBSERVAÇÕES:
//VERIFICAR SOBRE ENTRADAS SEREM TODAS MAIUSCULAS

public class JogoDaForca extends Jogo {

    DesenhoForca desenhoForca; // usado para mostrar o desenho da forca

    // verificar implementação automática e aleatória da palavra e dica
    private String dica;
    private String palavraMisteriosa;

    // verificar divisão da palavra em caracteres -----------
    private ArrayList<String> letrasPalavraMist;

    private ArrayList<String> letrasErradas = new ArrayList<>(); // usada para printar ao final do jogo
    private ArrayList<String> letrasCorretas = new ArrayList<>(); // usada para printar ao final do jogo
    private ArrayList<String> letrasJogadas = new ArrayList<>(); // usada para printar ao final do jogo
    private String[] letrasAdvinhadas; // usada para printar o jogo (___A_)
    private int tentativas; // usada para controlar tentativas (caracteres da palavra + 4)
    private int tentativasErradas;

    // classe recebe a palavra e dica
    // classe pai não possui atributos
    public JogoDaForca(String palavraMisteriosa, String dica) {
        this.palavraMisteriosa = palavraMisteriosa;
        this.dica = dica;
        this.letrasAdvinhadas = new String[this.letrasPalavraMist.size()]; // caracteres palavra + 4
        Arrays.fill(this.letrasAdvinhadas, "_"); // usado para definir indices com "_" por padrão
        desenhoForca = new DesenhoForca();

    }

    // analisa a letra e inclui nas listas (erradas, corretas) e nas jogadas.
    // se for correta insere na lista de advinhadas
    // main analisa se tem tentativas, antes de chamar TENTATIVA, se -1 = 0, não roda.
    public boolean tentativa(String letra) {
        boolean resultadoVerificaLetra = this.verificarLetra(letra);
        // se encontrar a letra na palavra
        // advinhadas, corretas e jogadas
        if (resultadoVerificaLetra) {
            for (int i = 0; i < this.letrasPalavraMist.size(); i++) {
                String letraFor = this.letrasPalavraMist.get(i);
                if (letraFor.equals(letra)) {
                    this.letrasAdvinhadas[i] = letraFor;
                }
            }
            this.letrasCorretas.add(letra);
            this.letrasJogadas.add(letra);
            return true;
        } else {
            // se não encontrar a letra na palavra
            // erradas e jogadas
            this.tentativas -= 1;
            this.letrasErradas.add(letra);
            this.letrasJogadas.add(letra);
            return false;
        }
    }

    // valida se a letra informada pelo usuario esta dentro da palavra
    private boolean verificarLetra(String letra) {
        for (String letraFor : this.letrasPalavraMist) {
            if (letraFor.equals(letra)) {
                return true; // letra encontrada
            }
        }
        return false;
    }

    // verifica se palpite do usuario sobre a palavra é true ou false
    // validar pelo main, se retornar true vai direto para a tela final
    public boolean palpitePalavra(String palavra) {
        boolean resultado;
        if (this.palavraMisteriosa.equals(palavra)) {
            resultado = true;
        } else {
            resultado = false;
        }
        return resultado;
    }

    // verifica se tem tentativas disponíveis
    // chamada no main, ao finalizar cada tentativa, ele vai validar se vai deixar jogar uma proxima.
    public boolean verificadorTentativas() {
        return this.tentativas == 0;
    }

    //chamada no main para verificar se todas as palavras foram advinhadas
    public boolean verificarVitoria() {
        for (int i = 0; i < this.letrasAdvinhadas.length; i++) {
            String letraFor = this.letrasAdvinhadas[i];
            if (letraFor.equals("_")) {
                return false;
            }
        }
        return true;
    }

    // valida se o usuario ja tentou essa letra - chamado no main
    public boolean verificarAdvinhadas(String letra){
        for (int i = 0; i < this.letrasAdvinhadas.length; i++) {
            String letraFor = this.letrasAdvinhadas[i];
            if (letraFor.equals(letra)) {
                return true;
            }
        }
        return false;
    }
}


