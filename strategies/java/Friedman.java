import java.util.Scanner;

public class Friedman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean firstBlood = false;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if ("GO".equals(line)) {
                System.out.println("C");
            } else if ("T".equals(line)) {
                firstBlood = true;
                System.out.println("T");
            } else {
                if (firstBlood)
                    System.out.println("T");
                else {
                    System.out.println("C");
                }
            }
        }
    }
}