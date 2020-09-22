import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }

        int count = 1;
        int maxCount = 1;

        for (int i = 1; i < len; i++) {
            if (array[i] > array[i - 1]) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                }
                count = 1;
            }
        }

        System.out.println(maxCount > count ? maxCount : count);
    }
}