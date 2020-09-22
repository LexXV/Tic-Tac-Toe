import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < m; l++) {
                matrix[k][l] = scanner.nextInt();
            }
        }

        int i = scanner.nextInt();
        int j = scanner.nextInt();
        int val;

        for (int k = 0; k < n; k++) {
            val = matrix[k][i];
            matrix[k][i] = matrix[k][j];
            matrix[k][j] = val;
        }

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < m; l++) {
                System.out.print(matrix[k][l] + " ");
            }
            System.out.println();
        }
    }
}