import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        boolean result = true;

        for (int j = 0; j < len - 1; j++) {
            if (array[j] == n && array[j + 1] == m) {
                result = false;
                break;
            } else if (array[j] == m && array[j + 1] == n) {
                result = false;
                break;
            }
        }

        System.out.println(result);
    }
}