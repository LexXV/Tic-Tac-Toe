package tictactoe;

import java.util.Scanner;

class Game {
    private final Scanner scanner = new Scanner(System.in);
    private final char[][] field = new char[3][3];
    private char currentPlayer = 'X';

    private enum State {
        X_WINS,
        O_WINS,
        DRAW,
        NOT_FINISHED,
        IMPOSSIBLE
    }

    public void start() {
        while (getState() == State.NOT_FINISHED) {
            printField();
            move();
            switchPlayer();
        }
        printField();
        printState();
    }

    private void printField() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                char cell = field[i][j];
                if (cell == 0 || cell == '_') {
                    cell = ' ';
                }
                System.out.print(cell + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private void move() {
        int x, y;

        do {
            System.out.print("Enter the coordinates: ");
            String[] coordinates = scanner.nextLine().trim().split("\\s+");
            try {
                x = Integer.parseInt(coordinates[0]);
                y = Integer.parseInt(coordinates[1]);
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (x < 1 || x > 3 || y < 1 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            int row = 3 - y;
            int col = x - 1;

            if (field[row][col] != 0) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            field[row][col] = currentPlayer;
            break;
        } while (true);
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
    }

    private State getState() {
        String[] rows = new String[] {"", "", ""};
        String[] columns = new String[] {"", "", ""};
        String[] diagonals = new String[] {"", ""};
        int xs = 0;
        int os = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char cell = field[i][j];
                if (cell == 'X') {
                    xs++;
                } else if (cell == 'O') {
                    os++;
                }

                rows[i] += cell;
                columns[j] += cell;

                if (i == j) {
                    diagonals[0] += cell;
                }
                if (i + j == 2) {
                    diagonals[1] += cell;
                }
            }
        }

        String combined = String.join(",", rows) + "," + String.join(",", columns) + "," + String.join(",", diagonals);
        boolean xWins = combined.contains("XXX");
        boolean oWins = combined.contains("OOO");

        if (Math.abs(os - xs) > 1 || (xWins && oWins)) {
            return State.IMPOSSIBLE;
        }

        if (xWins) {
            return State.X_WINS;
        } else if (oWins) {
            return State.O_WINS;
        }

        if (os + xs < 9) {
            return State.NOT_FINISHED;
        }

        return State.DRAW;
    }

    public void printState() {
        switch (getState()) {
            case X_WINS:
                System.out.println("X wins");
                break;
            case O_WINS:
                System.out.println("O wins");
                break;
            case DRAW:
                System.out.println("Draw");
                break;
            case NOT_FINISHED:
                System.out.println("Game not finished");
                break;
            case IMPOSSIBLE:
                System.out.println("Impossible");
                break;
            default:
                break;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new Game().start();
    }
}
