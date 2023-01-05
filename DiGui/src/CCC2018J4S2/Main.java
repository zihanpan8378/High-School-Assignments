package CCC2018J4S2;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] data = new int[n][n];
        int smallest = 1000000000;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = in.nextInt();
                if (data[i][j] < smallest) {
                    smallest = data[i][j];
                }
            }
        }

        if (smallest == data[0][0]) {
        } else if (smallest == data[n - 1][n - 1]) {
            data = rotate90(data);
            data = rotate90(data);
        } else if (smallest == data[n - 1][0]) {
            data = rotate90(data);
        } else if (smallest == data[0][n - 1]) {
            data = rotate90(data);
            data = rotate90(data);
            data = rotate90(data);
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public static int[][] rotate90(int[][] data) {
        int[][] after = new int[data.length][data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                after[i][j] = data[data.length - 1 - j][i];
            }
        }
        return after;
    }
}
