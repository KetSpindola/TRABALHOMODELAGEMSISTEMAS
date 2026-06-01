1. Classe: Main
Objetivo: Controlar a Interface de Linha de Comando (CLI) e interagir com o usuário.
Atributos: scan (Scanner estático para leitura de teclado).
Métodos: cabecalhoInicial(), menuInicial(), menuTentativa(), main().
Relacionamentos: Instancia o modelo JogoDaForca e controla o fluxo de execução baseado nos retornos lógicos dele.

2. Classe: Jogo
Objetivo: Servir como superclasse (Herança) genérica para qualquer tipo de jogo.
Atributos: Nenhum.
Métodos: Construtor vazio Jogo().
Relacionamentos: É a classe pai (superclasse) de JogoDaForca.

3. Classe: JogoDaForca
Objetivo: Centralizar todas as regras de negócio, validações e estado da partida.
Atributos: desenhoForca (objeto), dica (String), palavraMisteriosa (String), letrasPalavraMist (ArrayList), letrasErradas (ArrayList), letrasCorretas (ArrayList), letrasJogadas (ArrayList), letrasAdvinhadas (Array nativo), tentativas (int), tentativasErradas (int).
Métodos: tentativa(), verificarLetra(), palpitePalavra(), verificadorTentativas(), verificarVitoria(), verificarAdvinhadas().
Relacionamentos: Herda de Jogo (É um Jogo). Possui uma composição com DesenhoForca (Tem um Desenho). Recebe os comandos do Main e processa as respostas matemáticas.

4. Classe: DesenhoForca
Objetivo: Armazenar e fornecer os gráficos em ASCII da forca.
Atributos: desenhoErros (ArrayList de Strings contendo cada estágio do enforcamento).
Métodos: Construtor (que popula a lista) e retornoErros(int) (que devolve a imagem correta com base no número de erros).
Relacionamentos: É instanciada e utilizada exclusivamente de forma interna pela classe JogoDaForca.
