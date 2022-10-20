package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = numbers;
        }
        int primaryDiagonalSum = 0;

        for (int rows = 0; rows < matrixSize; rows++) {
            primaryDiagonalSum += matrix[rows][rows];
        }
        int secDiagonalSum = 0;

        for (int i = 0; i < matrixSize; i++) {
            secDiagonalSum += matrix[i][matrixSize - 1 - i];
        }
        int difference = Math.abs(primaryDiagonalSum - secDiagonalSum);
        System.out.println(difference);
    }
}
