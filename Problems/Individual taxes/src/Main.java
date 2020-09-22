import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];
        double maxTax = 0;
        int comp = 1;
        double tax;

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            tax = array[i] / 100.0 * scanner.nextInt();
            if (tax > maxTax) {
                comp = i + 1;
                maxTax = tax;
            }
        }

        System.out.println(comp);
    }
}