import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] array = new int[len];
        int maxIndex = 0;

        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }

        System.out.println(maxIndex);
    }
}