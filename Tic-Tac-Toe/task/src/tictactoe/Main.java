package tictactoe;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter cells:");
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
        printField(field);

        String result = Math.abs(xs-os) > 1 || xxx && ooo ? "Impossible"
                : xxx ? "X wins"
                : ooo ? "O wins"
                : xs + os == 9 ? "Draw"
                : "Game not finished";

        //System.out.println(result);

        System.out.println("Enter the coordinates:");
        enterCoordinates(field);

        printField(field);
    }

    static void printField(char[][] field) {
        System.out.println("---------");
        System.out.println("| " + field[0][0] + " " + field[0][1] + " " + field[0][2] + " |");
        System.out.println("| " + field[1][0] + " " + field[1][1] + " " + field[1][2] + " |");
        System.out.println("| " + field[2][0] + " " + field[2][1] + " " + field[2][2] + " |");
        System.out.println("---------");
    }

    static char[][] enterCoordinates(char[][] field) {
        while (true) {
            String[] coordinates = getCoordinates();
            if (coordinates[0].equals("String") || coordinates[1].equals("String")) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            if (x < 1 || x > 3 || y < 1 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else {
                boolean occupied = checkCell(x, y, field);
                if (occupied) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    field[3 - y][x - 1] = 'X';
                    return field;
                }
            }
        }
    }

    static String[] getCoordinates() {
        Scanner scanner = new Scanner(System.in);

        String[] coordinates = new String[2];
        for (int i = 0; i < 2; i++) {
            if (scanner.hasNextInt()) {
                coordinates[i] = String.valueOf(scanner.nextInt());
            } else if (scanner.hasNext()) {
                coordinates[i] = "String";
                return coordinates;
            }
        }
        return coordinates;
    }

    static boolean checkCell(int x, int y, char[][] field) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 3 - y && j == x - 1) {
                    if (field[i][j] == 'X' || field[i][j] == 'O') {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}