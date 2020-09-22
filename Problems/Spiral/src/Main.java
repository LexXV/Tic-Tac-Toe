import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int val = 1;

        while (val <= n * n) {
            for (int j = left; j <= right; j++) {
                matrix[top][j] = val;
                val++;
            }

            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = val;
                val++;
            }

            right--;

            for (int j = right; j >= left; j--) {
                matrix[bottom][j] = val;
                val++;
            }

            bottom--;

            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = val;
                val++;
            }

            left++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}