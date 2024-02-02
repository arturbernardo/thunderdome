Crie um arquivo Java contendo o método principal. Integre uma estratégia que interage por meio da leitura e escrita nos fluxos de entrada e saída padrão (stdin e stdout).

Ao iniciar, cada jogador receberá a mensagem "GO", indicando que é o momento de realiza o primeiro movimento. Posteriormente, eles receberão o feedback do oponente e devem reagir imediatamente, enviando o próximo movimento.

O Thunderdome assume a responsabilidade de iniciar e encerrar os JARs das estratégias. O JAR da estratégia deve permanecer em execução até ser finalizado.

Para incorporar estratégias já compiladas, é necessário adicioná-las à pasta "players". Alternativamente, você pode especificar outra pasta como argumento ao executar o programa.

A compilação do código Java pode ser realizada com os comandos:

Pode-se commpilar comando a comando:
javac YourStrategyMain.java
jar cfe YourStrategy.jar YourStrategyMain YourStrategyMain.class
java -jar YourStrategy.jar

Ou pode-se compilar usando os arquivos bash
./compile.sh TipForTat garbage
./compileAndRun.sh TipForTat