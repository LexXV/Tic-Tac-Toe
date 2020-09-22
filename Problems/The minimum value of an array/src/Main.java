import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }

        int minValue = array[0];

        for (int j : array) {
            if (j < minValue) {
                minValue = j;
            }
        }

        System.out.println(minValue);
    }
}