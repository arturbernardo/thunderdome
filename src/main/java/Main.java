import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static String directory = "players";
    static String idDelimiter = "-VS-";
    public static void main(String[] args) throws IOException {
        if (args.length > 0)
            directory = args[0];

        int gameSize = 20;

        HashMap<String, ArrayList<GameSet>> scores = new HashMap<>();

        List<String> players = listFiles();

        for (int i = 0; i < players.size() - 1; i++) {
            for (int j = i + 1; j < players.size(); j++) {
                String playerAName = players.get(i);
                String playerBName = players.get(j);
                ArrayList<GameSet> gameSets = new ArrayList<>();

                Process firstPlayer = Runtime.getRuntime().exec(new String[]{"java", "-jar", directory +"/"+playerAName});
                BufferedReader firstPReader = new BufferedReader(new InputStreamReader(firstPlayer.getInputStream()));
                PrintWriter firstPWriter = new PrintWriter(firstPlayer.getOutputStream(), true);

                Process secondPlayer = Runtime.getRuntime().exec(new String[]{"java", "-jar", directory +"/"+playerBName});
                BufferedReader secondPReader = new BufferedReader(new InputStreamReader(secondPlayer.getInputStream()));
                PrintWriter secondPWriter = new PrintWriter(secondPlayer.getOutputStream(), true);

                stopIfProcessIsToLong(firstPlayer, secondPlayer);

                firstPWriter.println("GO");
                secondPWriter.println("GO");

                for (int rounds = 0; rounds < gameSize; rounds++) {
                    String firstPResponse = firstPReader.readLine();
                    String secondPResponse = secondPReader.readLine();

                    secondPWriter.println(firstPResponse);
                    firstPWriter.println(secondPResponse);

                    System.out.println("Fist response: " + firstPResponse);
                    System.out.println("Second response: " + secondPResponse);

                    gameSets.add(new GameSet(firstPResponse, secondPResponse));
                }

                scores.put(playerAName + idDelimiter + playerBName, gameSets);

                firstPlayer.destroy();
                secondPlayer.destroy();

            }
        }

        FileWriter arquivo = allTournamentFile(scores);
        arquivo.close();
    }

    public static List<String> listFiles() throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(directory))) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList());
        }
    }

    private static void stopIfProcessIsToLong(Process firstPlayer, Process secondPlayer) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10000);
                firstPlayer.destroy();
                secondPlayer.destroy();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
    }

    public static class GameSet {
        String fPlayerMove;
        String sPlayerMove;

        public GameSet(String f, String s) {
            fPlayerMove = f;
            sPlayerMove = s;
        }
    }

    private static FileWriter allTournamentFile(HashMap<String, ArrayList<GameSet>> scores) throws IOException {
        FileWriter arquivo = new FileWriter("tournament.csv", false);
        scores.forEach((key, value) -> {
            try {
                arquivo.write(key.replace(".jar", "") + ",");
                arquivo.write(key.replace(".jar", "").split(idDelimiter)[0] + ",");

                value.forEach(gameSet -> {
                    try {
                        arquivo.write(gameSet.fPlayerMove + ",");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

                arquivo.write("\n");

                arquivo.write(key.replace(".jar", "") + ",");
                arquivo.write(key.replace(".jar", "").split(idDelimiter)[1] + ",");

                value.forEach(gameSet -> {
                    try {
                        arquivo.write(gameSet.sPlayerMove + ",");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                arquivo.write("\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return arquivo;
    }

    private static FileWriter allTournamentFileToHuman(HashMap<String, ArrayList<GameSet>> scores) throws IOException {
        FileWriter arquivo = new FileWriter("fLineXsLine.csv", false);
        scores.forEach((key, value) -> {
            try {
                arquivo.write("###" + key.toUpperCase() + "###");
                arquivo.write("\n");

                value.forEach(gameSet -> {
                    try {
                        arquivo.write(gameSet.fPlayerMove + ",");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

                arquivo.write("\n");

                value.forEach(gameSet -> {
                    try {
                        arquivo.write(gameSet.sPlayerMove + ",");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                arquivo.write("\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return arquivo;
    }

    private static FileWriter fileFLineAndSLine(ArrayList<GameSet> gameSets) throws IOException {
        FileWriter arquivo = new FileWriter("fLineXsLine.csv", false);
        gameSets.forEach(gameSet -> {
            try {
                arquivo.write(gameSet.fPlayerMove + ",");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        arquivo.write("\n");

        gameSets.forEach(gameSet -> {
            try {
                arquivo.write(gameSet.sPlayerMove + ",");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return arquivo;
    }

    private static FileWriter fileFxSLine(ArrayList<GameSet> gameSets) throws IOException {
        FileWriter arquivo = new FileWriter("fversuss.csv", false);
        gameSets.forEach(gameSet -> {
            try {
                arquivo.write(gameSet.fPlayerMove + " x " + gameSet.sPlayerMove + ",");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return arquivo;
    }
}