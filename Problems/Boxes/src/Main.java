import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] box1 = new int[3];
        int[] box2 = new int[3];

        for (int i = 0; i < 3; i++) {
            box1[i] = scanner.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            box2[i] = scanner.nextInt();
        }

        Arrays.sort(box1);
        Arrays.sort(box2);

        int result = 0;

        for (int i = 0; i < 3; i++) {
            if (box1[i] > box2[i]) {
                result++;
            } else if (box1[i] < box2[i]) {
                result--;
            }
        }

        System.out.println(result == 3 ? "Box 1 > Box 2" : result == -3 ? "Box 1 < Box 2" : "Incompatible");
    }
}