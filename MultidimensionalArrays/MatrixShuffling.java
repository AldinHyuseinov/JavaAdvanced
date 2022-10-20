package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixSize = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[matrixSize[0]][matrixSize[1]];
        Pattern pattern = Pattern.compile("^swap (\\d+) (\\d+) (\\d+) (\\d+)$");

        for (int i = 0; i < matrixSize[0]; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            matrix[i] = input;
        }

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            Matcher matcher = pattern.matcher(command);

            if (matcher.find()) {
                int row1 = Integer.parseInt(matcher.group(1));
                int col1 = Integer.parseInt(matcher.group(2));
                int row2 = Integer.parseInt(matcher.group(3));
                int col2 = Integer.parseInt(matcher.group(4));

                if (row1 >= matrixSize[0] || row2 >= matrixSize[0] || col1 >= matrixSize[1] || col2 >= matrixSize[1]) {
                    System.out.println("Invalid input!");
                } else {
                    String[] arr = new String[matrixSize[1]];

                    for (int i = 0; i < matrixSize[1]; i++) {
                        arr[i] = matrix[row1][i];
                    }
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = arr[col1];

                    for (String[] item : matrix) {

                        for (int i = 0; i < matrixSize[1]; i++) {
                            System.out.print(item[i] + " ");
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }
}
