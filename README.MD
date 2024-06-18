# Thunderdome

Este é um projeto baseado no artigo de Robert Axelrod, "Effective Choice in the Prisoner’s Dilemma" (Axelrod, R. 1980). 

A implementação foi inspirada pelo vídeo do Derek Muller (Veritasium), disponível [aqui](https://www.youtube.com/watch?v=mScpHTIi-kM).

Postagem no linkedin com mais ideias sobre o projeto [linkedin](https://www.linkedin.com/feed/update/urn:li:activity:7159245639422296064/)

## Estrutura do Projeto

O Thunderdome é um jogo que simula interações baseadas no dilema do prisioneiro. Cada estratégia interage por meio da leitura e escrita nos fluxos de entrada e saída padrão (stdin e stdout). O Thunderdome inicia e encerra os JARs das estratégias, e o JAR de uma estratégia deve permanecer em execução até ser finalizado.

## Instruções de Uso

1. **Crie uma estratégia:**
    - Crie um arquivo .java contendo um método main.
    - O algoritmo deve rodar até que seja encerrado por terceiros, visto que o Thunderdome irá controlar o jogo.
    - O primeiro movimento será sinalizado pela mensagem "GO". A estratégia deve responder com seu primeiro movimento.
    - Se a estratégia pretende colaborar, deve responder C, se pretende trair, deve responder T.
    - O Thunderdome cruza o retorno das duas estratégias, computa o resultado e as informa qual foi o movimento anterior do oponente.
    - Ao receber a informação com o movimento do oponente, a estratégia deve computar como reagir e responder imediatamente.
    - Nenhuma outra informação deve ser lida ou escrito via std.
    - A pasta strategies contém diversos exemplos.

2. **Compilação do Código Java:**
    - Compile suas estratégias:
      ```
      javac YourStrategyMain.java
      jar cfe YourStrategy.jar YourStrategyMain YourStrategyMain.class
      java -jar YourStrategy.jar
      ```
   - As coloque no diretório acessado pelo Thunderdome:
     - caso rode via IDE, a pasta players é a padrão. Outra pode ser passada por parâmetro.
     - caso crie um jar do thunderdome, crie um pasta players no mesmo nível do jar ou passe como parâmetro um path.
   
   - Ou use os scripts bash na pasta strategies, sendo o primeiro parâmetro o nome da estratégia (que deve corresponder ao nome do .java) e o segundo parâmetro do compile.sh a pasta destino:
     ```
     ./compile.sh YourStrategy pastaDestino
     ./compileAndRun.sh YourStrategy
     ```

3. **Adicionando Estratégias Compiladas:**
    - Adicione os JARs das estratégias à pasta "players".
    - Caso tenha usado o script fornecido, o jar já estará na pasta.
   
## Executando o Thunderdome

- Execute o Thunderdome:
- Output é um CSV chamado tournament.csv que será criado na raiz.


## Analises dos resultados ##
> 🚧 em construção 🚧

https://colab.research.google.com/drive/1Ex3tsVOQD64o72aIhgQ_nfW1lsHRvWTR#scrollTo=YZpBFi_mx1t4
