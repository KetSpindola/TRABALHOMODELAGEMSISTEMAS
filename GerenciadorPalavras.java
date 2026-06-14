package Trabalho;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// usado para ler as palavras do arquivo TXT que contem (PALAVRA DICA)
// le cada linha e inclui em um indice de uma lista, um indice é sorteado com random, esse indice tem as palavras dividas com split em um array
// como lista de desenhosforca possui somente 15 indices, as palavras se limitam a esse numero de letras
// criado no MAIN
public class GerenciadorPalavras {

    private ArrayList<String> linhas;
    private Random random;

    // construtor, recebe o caminho do arquivo
    // ja constroi a lista
    public GerenciadorPalavras(String caminhoArquivo) {
        this.linhas = new ArrayList<>();
        this.random = new Random();
        carregarPalavras(caminhoArquivo);
    }

    // usado no construtor
    private void carregarPalavras(String caminhoArquivo) {
        try (Scanner scanner = new Scanner(new File(caminhoArquivo))) {
            while (scanner.hasNextLine()) { // enquanto houver proxima linha
                String linha = scanner.nextLine();
                if (!linha.trim().isEmpty()) { // se não estiver vazia
                    this.linhas.add(linha);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Houve uma falha ao tentar ler o arquivo. Altere o caminho pré definido no código MAIN.\n" + e);
        }
    }

    // sorteia um indice, separa palavras e devolve em uma lista
    public String[] obterPalavraAleatoria() {
        int indice = random.nextInt(this.linhas.size()); // sorteio do tamanho da lista
        String linha = this.linhas.get(indice);
        String[] partes = linha.split(" "); // separa palavras pelo espaço

        return partes;
    }
}