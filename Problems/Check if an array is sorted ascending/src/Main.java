import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }

        boolean ascend = true;

        for (int j = 0; j < len - 1; j++) {
            if (array[j] > array[j + 1]) {
                ascend = false;
            }
        }

        System.out.println(ascend);
    }
}