package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        char[] array = scanner.nextLine().toCharArray();
        char[][] field = new char[3][3];

        int xs = 0;
        int os = 0;
        boolean xxx = false;
        boolean ooo = false;

        // fill up the field, count X's & O's
        for (int i = 0; i < 9; i++) {
            field[i / 3][i % 3] = array[i];

            if (array[i] == 'X') {
                xs++;
            } else if (array[i] == 'O') {
                os++;
            }
        }

        // check if row or column or any of diagonals is win for someone
        for (int i = 0; i < 3; i++) {
            int row = 0;
            int clm = 0;
            int mainDiag = 0;
            int antiDiag = 0;

            for (int j = 0; j < 3; j++) {
                row += field[i][j];
                clm += field[j][i];
                mainDiag += field[j][j];
                antiDiag += field[j][2-j];
            }

            // ASCII value for X is 88 (X+X+X is 264)
            // ASCII value for O is 79 (O+O+O is 237)
            xxx = xxx || row == 264 || clm == 264 || mainDiag == 264 || antiDiag == 264;
            ooo = ooo || row == 237 || clm == 237 || mainDiag == 237 || antiDiag == 237;
        }

        // print field and result
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.println(String.format("| %c %c %c |", field[i][0], field[i][1], field[i][2]));
        }
        System.out.println("---------");

        String result = Math.abs(xs-os) > 1 || xxx && ooo ? "Impossible"
                : xxx ? "X wins"
                : ooo ? "O wins"
                : xs + os == 9 ? "Draw"
                : "Game not finished";

        System.out.println(result);
    }
}