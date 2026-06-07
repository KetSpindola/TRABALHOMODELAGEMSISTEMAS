# Jogo da Forca em Java (CLI) 🎮

Bem-vindo(a) ao repositório do Jogo da Forca! Este projeto foi desenvolvido inteiramente em Java puro para execução via Linha de Comando (CLI). 
O sistema aplica os pilares da Programação Orientada a Objetos (POO), organizando regras de negócio, interface e estados do jogo em uma arquitetura modular. O projeto inclui leitura e persistência de palavras através de arquivos texto `.txt`.

## 🏗️ Arquitetura e Detalhamento de Classes

O sistema foi dividido em quatro classes principais para garantir o desacoplamento e a organização lógica:

### 1. Classe `Main`
* **Objetivo:** Ponto de entrada do sistema. Gerencia a Interface de Linha de Comando (CLI), a navegação por menus e a interação (Entrada/Saída) com o usuário.
* **Atributos Principais:** * `scan`: Scanner estático para captura de dados do teclado.
* **Métodos Principais:** * `cabecalhoInicial()`, `menuInicial()`, `menuTentativa()`, `main()`.
* **Relacionamentos:** Instancia a classe `JogoDaForca` e controla o laço de execução contínua baseado no estado do jogo.

### 2. Classe `Jogo` (Superclasse)
* **Objetivo:** Estabelecer a base para a estrutura de herança do sistema, servindo como modelo genérico para futuras implementações de outros jogos.
* **Atributos:** Sem atributos definidos.
* **Métodos:** Construtor padrão `Jogo()`.
* **Relacionamentos:** Superclasse (Classe Pai) de `JogoDaForca`.

### 3. Classe `JogoDaForca`
* **Objetivo:** Centralizar o "coração" do jogo. Retém o estado da partida, as validações lógicas, regras de vitória/derrota e gerenciamento de acertos e erros.
* **Atributos Principais:** * `palavraMisteriosa` e `dica`: Textos sorteados (String).
  * `letrasPalavraMist`, `letrasErradas`, `letrasCorretas`, `letrasJogadas`: Listas dinâmicas (ArrayList) de controle de caracteres.
  * `letrasAdvinhadas`: Array estático de controle visual do tabuleiro.
  * `tentativas`, `tentativasErradas`: Contadores numéricos (int).
  * `desenhoForca`: Objeto gerador da arte ASCII.
* **Métodos Principais:** * `tentativa()`: Valida inserção da letra.
  * `verificarLetra()`: Analisa se a letra pertence à palavra misteriosa.
  * `palpitePalavra()`: Verifica tentativa direta da palavra completa.
  * `verificadorTentativas()` e `verificarVitoria()`: Retornam flags booleanas sobre o término da partida.
* **Relacionamentos:** Herda de `Jogo`. Possui composição com `DesenhoForca`.

### 4. Classe `DesenhoForca`
* **Objetivo:** Isolar a responsabilidade gráfica do jogo.
* **Atributos Principais:** * `desenhoErros`: ArrayList de Strings contendo todos os 15 frames/estágios do enforcamento em formato ASCII Art.
* **Métodos Principais:** * `retornoErros(int numeroErros)`: Retorna o frame visual exato baseado na quantidade de falhas do jogador atual.
* **Relacionamentos:** É instanciada exclusivamente pela classe `JogoDaForca`.

---
*Projeto acadêmico desenvolvido para a disciplina de Modelagem e Programação de Sistemas Computacionais.*
