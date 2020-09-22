import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }

        int maxProduct = array[0] * array[1];

        for (int j = 1; j < len - 1; j++) {
            int product = array[j] * array[j + 1];
            if (product > maxProduct) {
                maxProduct = product;
            }
        }

        System.out.println(maxProduct);
    }
}