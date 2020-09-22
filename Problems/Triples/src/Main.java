import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }

        int count = 0;

        for (int i = 1; i < len - 1; i++) {
            if (array[i + 1] == array[i] + 1 && array[i] == array[i - 1] + 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}