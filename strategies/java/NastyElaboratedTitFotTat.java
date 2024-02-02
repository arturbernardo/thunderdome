import java.util.Random;
import java.util.Scanner;

public class NastyElaboratedTitFotTat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if ("GO".equals(line)) {
                System.out.println("C");
            } else {
                double randomValue = random.nextDouble();
                if (randomValue < 0.1)
                    System.out.println("T");
                else
                    System.out.println(line);
            }
        }
    }
}