import java.util.Scanner;

public class TitForTat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if ("GO".equals(line)) {
                System.out.println("C");
            } else {
                System.out.println(line);
            }
        }
    }
}