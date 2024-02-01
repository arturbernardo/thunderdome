import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int rand = random.nextInt() % 2;
            if (rand == 0)
                System.out.println("C");
            else
                System.out.println("T");
        }
    }
}