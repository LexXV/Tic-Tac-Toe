import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int shift = scanner.nextInt();
        int size = array.length;

        String[] newArray = new String[size];

        for (int i = 0; i < size; i++) {
            newArray[(i + shift) % size] = array[i];
        }

        for (String val : newArray) {
            System.out.print(val + " ");
        }
    }
}