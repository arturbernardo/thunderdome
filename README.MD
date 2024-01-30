Crie um arquivo java com método main.
Nele adicione a estratégia, que deve ler stdin e stdout e responder via System.out.println.
A primeira mensagem que a será enviada para cada jogador é "GO", indicando que devem fazer seus movimentos.
A partir desta mensagem eles receberão o feedback do oponente e devem responder imediatamente com o próximo movimento.
O thunderdome inicia os jars e os finaliza. A jar da estratégia deve rodar até ser finalizado.


javac Main.java

jar cfe YourStrategy.jar Main Main.class

java -jar YourStrategy.jar
