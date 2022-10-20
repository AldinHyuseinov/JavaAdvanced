package MultidimensionalArrays;

import java.util.Scanner;

public class FillMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int matrixSize = Integer.parseInt(input[0]);
        int[][] matrix = new int[matrixSize][matrixSize];

        if (input[1].equals("A")) {
            patternA(matrix);
        } else {
            patternB(matrix);
        }
        printMatrix(matrix);
    }

    public static void patternA(int[][] matrix) {
        int counter = 1;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = counter;
                counter++;
            }
        }
    }

    public static void patternB(int[][] matrix) {
        int counter = 1;

        for (int i = 0; i < matrix.length; i++) {

            if (i % 2 == 0) {

                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = counter;
                    counter++;
                }
            } else {

                for (int j = matrix.length - 1; j >= 0; j--) {
                    matrix[j][i] = counter;
                    counter++;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {

        for (int[] ints : matrix) {

            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
