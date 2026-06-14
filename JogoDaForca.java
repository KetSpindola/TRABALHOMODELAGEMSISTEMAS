package Trabalho;

import java.util.ArrayList;
import java.util.Arrays;

//CLASSE MÃE:
// - JOGO--
public class JogoDaForca extends Jogo {

    // objeto para mostrar forca - cada partida (jogo) tem o seu
    private DesenhoForca desenhoForca;

    // recebidas no construtor
    private int tentativasErradas; // usado como indice para a lista que contem os estados da forca
    private String dica;
    private String palavraMisteriosa;

    // palavra dividida no construtor, usada para comparações pois possui todas as letras da palavra.
    private ArrayList<String> letrasPalavraMist;

    // listas dinâmicas:
    private ArrayList<String> letrasErradas = new ArrayList<>(); // usada para printar ao final do jogo
    private ArrayList<String> letrasCorretas = new ArrayList<>(); // usada para printar ao final do jogo
    private ArrayList<String> letrasJogadas = new ArrayList<>(); // usada para printar ao final do jogo

    // array estático:
    private String[] letrasAdvinhadas; // usada para printar o jogo (___A_)


    // CONSTRUTOR
    public JogoDaForca(String palavraMisteriosa, String dica, String nomeJogador) {
        super(nomeJogador);// palavra e dica recebida
        this.palavraMisteriosa = palavraMisteriosa;
        this.dica = dica;

        desenhoForca = new DesenhoForca(); // criando objeto para mostrar forca
        this.tentativasErradas = 0; // indice lista estado forca, sempre iniciado em 0

        // dividindo letras palavra
        this.letrasPalavraMist = new ArrayList<>();
        for (char letra : palavraMisteriosa.toCharArray()) {
            letrasPalavraMist.add(String.valueOf(letra));
        }

        this.letrasAdvinhadas = new String[this.letrasPalavraMist.size()]; // criando vetor de visualização no tamanho da palavra
        Arrays.fill(this.letrasAdvinhadas, "_"); // definir indices do vetor de visualização para "_" por padrão

        // atributo classe MÃE
        this.tentativas = this.letrasPalavraMist.size(); //tentativas de erro com numero de letras da palavra
    }

    // usado no metodo TENTATIVA
    private boolean verificarNaPalavra(String letra) {
        for (String letraFor : this.letrasPalavraMist) {
            if (letraFor.equals(letra)) {
                return true; // letra na palavra
            }
        }
        return false;
    }

    // PRINCIPAL
    // recebe a letra e verifica se esta na palavra
    // Esta - True
    // Não esta - False
    public boolean tentativa(String letra) {

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

    // usado no MAIN
    public boolean verificarJajogada(String letra) {
        for (String letraFor : this.letrasJogadas) {
            if (letraFor.equals(letra)) {
                return true; // letra ja jogada
            }
        }
        return false;
    }

    // usado no MAIN
    public boolean palpitePalavra(String palavra) {

        return this.palavraMisteriosa.equals(palavra); // acertou - True
    }

    // usados pelo metodo EXIBIRESTADOJOGO
    // metodos para printar vetores (jogadas, corretas, erradas, advinhadas)
    // um recebe lista, outro array
    private void lerVetor(String[] array) {
        if (array.length == 0) { // primeiro verifica se esta vazio
            System.out.println("nenhuma");
        } else { // se não estiver le os indices
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    private void lerVetor(ArrayList<String> lista) {
        if (lista.isEmpty()) { // primeiro verifica se esta vazio
            System.out.println("nenhuma");
        } else {
            for (int i = 0; i < lista.size(); i++) { // se não estiver le os indices
                System.out.print(lista.get(i) + " ");
            }
            System.out.println();
        }
    }

    // usado no MAIN
    public void exibirEstadoJogo() {
        System.out.println("        J O G O   D A   F O R C A");
        System.out.println("========================================");
        System.out.println("- JOGADOR: " + nomeJogador);
        System.out.println("- DICA: " + this.dica);
        System.out.println("- TAMANHO DA PALAVRA: " + letrasPalavraMist.size());
        System.out.println("Tentativas permitidas: " + letrasPalavraMist.size());
        System.out.println("Tentativas restantes: " + this.tentativas);
        System.out.print("Letras ja jogadas: ");
        lerVetor(this.letrasJogadas);
        System.out.print("Acertadas: ");
        lerVetor(this.letrasCorretas);
        System.out.print("Erradas: ");
        lerVetor(this.letrasErradas);
        System.out.println(desenhoForca.retornoErros(this.tentativasErradas));
        lerVetor(this.letrasAdvinhadas);
    }

    //usado no main
    public void exibirPlacarFinal(String resultado) {
        System.out.println("     R E S U L T A D O   F I N A L");
        System.out.println("JOGADOR: " + nomeJogador);
        System.out.println("========================================");
        System.out.println("Resultado: " + resultado);
        System.out.println("Palavra: " + this.palavraMisteriosa);
        System.out.println("Dica era: " + this.dica);
        System.out.println("========================================");
        System.out.println("ESTATÍSTICAS:");
        System.out.println("- Total de tentativas usadas: " + this.tentativasErradas);
        System.out.println("- Tentativas restantes: " + this.tentativas);
        System.out.println("- Letras corretas: " + this.letrasCorretas.size());
        System.out.println("- Letras erradas: " + this.letrasErradas.size());
        System.out.println("========================================");
        System.out.println("HISTÓRICO DE LETRAS:");
        System.out.print("- Corretas: ");
        lerVetor(this.letrasCorretas);
        System.out.print("- Erradas: ");
        lerVetor(this.letrasErradas);
        System.out.println("========================================");
        System.out.println("Forca final: ");
        System.out.println(desenhoForca.retornoErros(tentativasErradas));
    }

    // usado no metodo VERIFICARRESULTADO
    private boolean verificarVitoria() {
        for (int i = 0; i < this.letrasAdvinhadas.length; i++) {
            String letraFor = this.letrasAdvinhadas[i];
            if (letraFor.equals("_")) {
                return false;
            }
        }
        return true; // todas a letras foram advinhadas
    }

    // usado do MAIN
    public String verificarResultado() {
        // Se não tem mais tentativas = DERROTA
        if (this.tentativas <= 0) {
            return "DERROTA";
        }

        // Se descobriu todas as letras = VITORIA
        if (verificarVitoria()) {
            return "VITORIA";
        }

        // Se nenhuma das duas = continua jogando
        return "CONTINUA";
    }
}




