import java.util.*;

public class OneAnalysisDumb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> firstMoves = new ArrayList<>();
        firstMoves.add("C");
        firstMoves.add("C");
        firstMoves.add("C");
        firstMoves.add("C");
        firstMoves.add("C");
        firstMoves.add("C");
        firstMoves.add("T");
        firstMoves.add("T");
        firstMoves.add("T");
        firstMoves.add("T");
        firstMoves.add("T");

        Map<String, Integer> scores = new HashMap<>();
        scores.put("C", 0);
        scores.put("T", 0);

        int count = 0;
        String move;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!"GO".equals(line)) {
                if (firstMoves.get(count-1).equals("C") && line.equals("C")) {
                    scores.put("C", scores.get("C") + 3);
                } else if (firstMoves.get(count-1).equals("C") && line.equals("T")) {
                    //
                } else if (firstMoves.get(count-1).equals("T") && line.equals("T")) {
                    scores.put("T", scores.get("T") + 1);
                } else if (firstMoves.get(count-1).equals("T") && line.equals("C")) {
                    scores.put("T", scores.get("T") + 5);
                }
            }

            if (count < 11) {
                move = firstMoves.get(count);
            } else {
                if (scores.get("C") > scores.get("T")) {
                    move = "C";
                } else {
                    move = "T";
                }
            }

            count++;

            firstMoves.add(move);
            System.out.println(move);
        }
    }
}
