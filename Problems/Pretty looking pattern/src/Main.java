import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[4][4];

        for (int i = 0; i < 4; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        boolean pretty = true;
        char val;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                val = matrix[i][j];
                if (matrix[i + 1][j + 1] == val && matrix[i][j + 1] == val && matrix[i + 1][j] == val) {
                    pretty = false;
                }
            }
        }
        System.out.println(pretty ? "YES" : "NO");
    }
}