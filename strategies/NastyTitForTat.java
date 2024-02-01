import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String myMove = "";
        List<String> myLastMoveList = new ArrayList<>();
        List<String> opponentLastMove = new ArrayList<>();
        int count = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if ("GO".equals(line)) {
                count++;
                myMove = "T";
            }
            else if (count == 1){
                count++;
                myMove = "C";
            }
            else if ("C".equals(opponentLastMove.get(count-1)) && "C".equals(line)) {
                count++;
                myMove = "T";
            }
            else if ("C".equals(opponentLastMove.get(count-1)) && "T".equals(line)) {
                count++;
                myMove = "C";
            }
            else if ("T".equals(opponentLastMove.get(count-1)) && "C".equals(line)) {
                count++;
                myMove = "T";
            }
            else {
                count++;
                myMove = line;
            }
            opponentLastMove.add(line);
            myLastMoveList.add(myMove);
            System.out.println(myMove);
        }
    }
}