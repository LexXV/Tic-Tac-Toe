import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String[][] matrix = new String[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], ".");
        }

        for (int i = 0; i < n; i++) {
            matrix[i][i] = "*";
            matrix[i][n - 1 - i] = "*";
            matrix[i][n / 2] = "*";
            matrix[n / 2][i] = "*";
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}