import java.util.Scanner;

public class TitForDoubleTat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int treasonAcc = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if ("GO".equals(line)) {
                System.out.println("C");
            } else {
                if ("T".equals(line) && treasonAcc < 2) {
                    treasonAcc++;
                } else if ("C".equals(line)) {
                    treasonAcc = 0;
                }

                if (treasonAcc < 2) {
                    System.out.println("C");
                } else {
                    System.out.println("T");
                }
            }
        }
    }
}