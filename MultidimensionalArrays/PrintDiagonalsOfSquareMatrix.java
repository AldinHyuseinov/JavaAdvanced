package MultidimensionalArrays;

import java.util.*;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            String[] input = scanner.nextLine().split(" ");
            matrix[i] = input;
        }
        String[] firstDiagonal = new String[matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            firstDiagonal[i] = matrix[i][i];
        }
        String[] secDiagonal = new String[matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            secDiagonal[i] = matrix[i][matrixSize - 1 - i];
        }
        List<String> reverseDiagonal = new ArrayList<>(Arrays.asList(secDiagonal));
        Collections.reverse(reverseDiagonal);

        for (int i = 0; i < matrixSize; i++) {
            System.out.print(firstDiagonal[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < matrixSize; i++) {
            System.out.print(reverseDiagonal.get(i) + " ");
        }
    }

    public static void printMatrix(String[][] matrix) {

        for (String[] item : matrix) {

            for (int j = 0; j < matrix.length; j++) {
                System.out.print(item[j] + " ");
            }
            System.out.println();
        }
    }
}