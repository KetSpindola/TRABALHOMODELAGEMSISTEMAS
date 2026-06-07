package Trabalho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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
    private int tentativasErradas; // usado para printar a forca

    // classe pai só possui TENTATIVAS
    public JogoDaForca(String palavraMisteriosa, String dica) {

        desenhoForca = new DesenhoForca();
        this.tentativasErradas = 0; // para mostrar forca inicial

        this.palavraMisteriosa = palavraMisteriosa;
        this.dica = dica;

        this.letrasPalavraMist = new ArrayList<>();
        for (char letra : palavraMisteriosa.toCharArray()) {
            letrasPalavraMist.add(String.valueOf(letra));
        }

        this.letrasAdvinhadas = new String[this.letrasPalavraMist.size()]; // criando vetor de visualização no tamanho da palavra
        Arrays.fill(this.letrasAdvinhadas, "_"); // usado para definir indices do vetor de visualização com "_" por padrão

        this.tentativas = this.letrasPalavraMist.size(); //tentativas de erro com numero de letras da palavra


    }

    // valida se a letra informada pelo usuario ja foi jogada
    // validar no main antes da jogada
    public boolean verificarJajogada(String entrada) {
        String letra = maiuscula(entrada); // definindo como maiscula
        for (String letraFor : this.letrasJogadas) {
            if (letraFor.equals(letra)) {
                return true; // letra ja jogada
            }
        }
        return false;
    }

    // valida se a letra informada pelo usuario esta dentro da palavra
    private boolean verificarNaPalavra(String letra) {
        for (String letraFor : this.letrasPalavraMist) {
            if (letraFor.equals(letra)) {
                return true; // letra encontrada
            }
        }
        return false;
    }

    public boolean tentativa(String entrada) {

        String letra = maiuscula(entrada); // definindo como maiscula
        boolean resultadoNaPalavra = this.verificarNaPalavra(letra); // verifica se a letra esta na palavra

        // se encontrar a letra na palavra
        // advinhadas, corretas e jogadas
        if (resultadoNaPalavra) { //retorna true se a letra foi encontrada

            for (int i = 0; i < this.letrasPalavraMist.size(); i++) {
                String letraFor = this.letrasPalavraMist.get(i);
                if (letraFor.equals(letra)) {
                    this.letrasAdvinhadas[i] = letraFor;
                }
            }
            this.letrasCorretas.add(letra);
            this.letrasJogadas.add(letra);
            return true; //LETRA ACERTADA

        } else {
            // se não encontrar a letra na palavra
            // erradas e jogadas
            this.tentativas -= 1;
            this.tentativasErradas += 1;
            this.letrasErradas.add(letra);
            this.letrasJogadas.add(letra);
            return false; // LETRA INCORRETA
        }
    }


    // verifica se palpite do usuario sobre a palavra é true ou false
    // validar pelo main, se retornar true vai direto para a tela final
    public boolean palpitePalavra(String entrada) {
        String palavra = maiuscula(entrada); // definindo como maiscula
        return this.palavraMisteriosa.equals(palavra);
    }

    // verifica se tem tentativas disponíveis
    // chamada no main, ao finalizar cada tentativa, ele vai validar se vai deixar jogar uma proxima.
    public boolean verificadorTentativas() {
        return this.tentativas == 0;
    }

    //chamada no main para verificar se todas as letras foram advinhadas
    public boolean verificarVitoria() {
        for (int i = 0; i < this.letrasAdvinhadas.length; i++) {
            String letraFor = this.letrasAdvinhadas[i];
            if (letraFor.equals("_")) {
                return false;
            }
        }
        return true; // todas a letras foram advinhadas
    }


    public void exibirEstadoJogo(){
        System.out.println("\n========================================");
        System.out.println("             JOGO DA FORCA");
        System.out.println("========================================");

        System.out.println("DICA: " + this.dica);
        System.out.println("Tentativas restantes: " + this.tentativas);

        System.out.println("Letras ja jogadas: ");
        lerArray(this.letrasJogadas);
        System.out.println("Acertadas: ");
        lerArray(this.letrasCorretas);
        System.out.println("Erradas: ");
        lerArray(this.letrasErradas);

        System.out.println(desenhoForca.retornoErros(this.tentativasErradas));

        System.out.println("\n");
        lerLista(this.letrasAdvinhadas);



        }

    private void lerLista(String[] lista){
        for (int i = 0; i < lista.length; i++){
            System.out.print(lista[i] + "");
        }
    }


    private void lerArray(ArrayList array){
        for (int i = 0; i < array.size(); i++){
            System.out.print(array.get(i) + "");
        }
    }
}




