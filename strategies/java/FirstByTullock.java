import java.util.*;

public class FirstByTullock {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        List<String> enemyMoves = new ArrayList<>();
//        int enemyTreason = 0;
        int count = 0;
        String move;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if ("GO".equals(line)) {
                move = "C";
            } else {
                if (count < 11) {
                    move = "C";
                } else {
                    long enemyTreason = enemyMoves.stream().filter(x -> x.equals("T")).count();
                    double percentage = enemyTreason*100/count;
                    percentage = percentage * 1.1;
                    int randomPercent = random.nextInt(101);

                    if (randomPercent <= percentage) {
                        move = "T";
                    } else {
                        move = "C";
                    }
                }


            }

            enemyMoves.add(line);
            count++;

            System.out.println(move);
        }
    }
}

//    Random random = new Random();
//    Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                int rand = random.nextInt() % 2;
//                if (rand == 0)
//                System.out.println("C");
//                else
//                System.out.println("T");
//                }
//                }
