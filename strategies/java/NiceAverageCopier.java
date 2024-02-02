import java.util.*;

public class NiceAverageCopier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> enemyCollaborate = new ArrayList<>();
        List<String> enemyTreason = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if ("GO".equals(line))
                System.out.println("C");
            else {
                if ("C".equals(line)) enemyCollaborate.add(line);

                if ("T".equals(line)) enemyTreason.add(line);

                if (enemyCollaborate.size() >= enemyTreason.size()) System.out.println("C");
                else System.out.println("T");
            }
        }
    }
}
