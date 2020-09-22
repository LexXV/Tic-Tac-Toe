import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        int maxRow = 0;
        int maxColumn = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[i][j] > matrix[maxRow][maxColumn]) {
                    maxRow = i;
                    maxColumn = j;
                }
            }
        }

        System.out.println(maxRow + " " + maxColumn);
    }
}