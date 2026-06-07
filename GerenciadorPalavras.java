package Trabalho;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GerenciadorPalavras {
    private ArrayList<String> linhas;
    private Random random;

    public GerenciadorPalavras(String caminhoArquivo) {
        this.linhas = new ArrayList<>();
        this.random = new Random();
        carregarPalavras(caminhoArquivo);
    }

    private void carregarPalavras(String caminhoArquivo) {
        try {
            Scanner scanner = new Scanner(new File(caminhoArquivo));
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (!linha.trim().isEmpty()) {
                    this.linhas.add(linha);
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public String[] obterPalavraAleatoria() {
        int indice = random.nextInt(this.linhas.size());
        String linha = this.linhas.get(indice);
        String[] partes = linha.split(" ");

        return new String[]{partes[0], partes[1]};
    }
}