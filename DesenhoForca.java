package Trabalho;

import java.util.ArrayList;

// classe usada para printar visualmente a forca
// cada indice da lista possui um nivel de estágio
// numeroErros é recebido em toda atualização do jogo
// criado para cada objeto forca
public class DesenhoForca {

    private ArrayList<String> desenhoErros = new ArrayList<>(); // 15 indices

    // construtor inicia com todos os indices
    public DesenhoForca() {
        desenhoErros.add("   _ _ _ \n   |    |\n        |\n        |\n        |\n        |\n _______|");//0
        desenhoErros.add("   _ _ _ \n   |    |\n   O    |\n        |\n        |\n        |\n _______|");
        desenhoErros.add("   _ _ _ \n   |    |\n   O    |\n   |    |\n        |\n        |\n _______|");
        desenhoErros.add("   _ _ _ \n   |    |\n   O    |\n   |    |\n   |    |\n        |\n _______|");
        desenhoErros.add("   _ _ _ \n   |    |\n   O    |\n   |    |\n   |    |\n   |    |\n _______|");
        desenhoErros.add("   _ _ _ \n   |    |\n   O    |\n  /|    |\n   |    |\n   |    |\n _______|");
        desenhoErros.add("   _ _ _ \n   |    |\n   O    |\n  /|/   |\n   |    |\n   |    |\n _______|");
        desenhoErros.add("   _ _ _ \n   |    |\n   O    |\n  /|/   |\n   |    |\n   |/   |\n _______|");
        desenhoErros.add("   _ _ _ \n   |    |\n   O    |\n  /|/   |\n   |    |\n  /|/   |\n _______|");
        desenhoErros.add("   _ _ _ \n   |    |\n   O~   |\n  /|/   |\n   |    |\n  /|/   |\n _______|");
        desenhoErros.add("   _ _ _ \n   |    |\n  ~O~   |\n  /|/   |\n   |    |\n  /|/   |\n _______|");
        desenhoErros.add("   _ _ _ \n   |    |\n  ~O~   |\n  /|_/  |\n   |    |\n  /|/   |\n _______|");
        desenhoErros.add("   _ _ _ \n   |    |\n  ~O~   |\n _/|_/  |\n   |    |\n  /|/   |\n _______|");
        desenhoErros.add("   _ _ _ \n   |    |\n  ~O~   |\n _/|_/  |\n   |    |\n  /|_/  |\n _______|");
        desenhoErros.add("   _ _ _ \n   |    |\n  ~O~   |\n _/|_/  |\n   |    |\n _/|_/  |\n _______|");//14
    }

    // devolve o print do índice de acordo com o número recebido
    public String retornoErros(int numeroErros) {
        return desenhoErros.get(numeroErros);
    }
}
