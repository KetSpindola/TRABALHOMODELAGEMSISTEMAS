package Trabalho;
import java.util.ArrayList;

public class DesenhoForca {

    private ArrayList<String> desenhoErros = new ArrayList<>();

    public DesenhoForca(){
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

    public String retornoErros(int numeroErros){
        return desenhoErros.get(numeroErros);
    }
}
