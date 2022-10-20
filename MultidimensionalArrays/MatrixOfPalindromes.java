package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixSize = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[matrixSize[0]][matrixSize[1]];
        StringBuilder palindrome = new StringBuilder();

        for (int rows = 0; rows < matrixSize[0]; rows++) {

            for (int col = 0; col < matrixSize[1]; col++) {
                palindrome.append((char) ('a' + rows));
                palindrome.append((char) ('a' + rows + col));
                palindrome.append((char) ('a' + rows));
                matrix[rows][col] = palindrome.toString();
                palindrome.setLength(0);
            }
        }

        for (String[] row : matrix) {

            for (int i = 0; i < matrixSize[1]; i++) {
                System.out.print(row[i] + " ");
            }
            System.out.println();
        }
    }
}
