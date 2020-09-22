import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] array = new int[len];

        for (int i = 1; i < len; i++) {
            array[i] = scanner.nextInt();
        }

        array[0] = scanner.nextInt();

        for (int val : array) {
            System.out.print(val + " ");
        }
    }
}