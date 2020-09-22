import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int k = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int counter = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter >= k) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }

        System.out.println(0);
    }
}