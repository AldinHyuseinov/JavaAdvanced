package ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[matrixSize][matrixSize];
        int commandCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < matrixSize; i++) {
            char[] row = scanner.nextLine().toCharArray();
            field[i] = row;
        }

        int playerRow = -1;
        int playerCol = -1;

        for (int row = 0; row < matrixSize; row++) {

            for (int col = 0; col < matrixSize; col++) {

                if (field[row][col] == 'P') {
                    field[row][col] = '.';
                    playerRow = row;
                    playerCol = col;
                    break;
                }
            }
        }

        for (int i = 0; i < commandCount; i++) {
            String moveCommands = scanner.nextLine();

            if (moveCommands.equals("up") || moveCommands.equals("down")) {
                playerRow = movement(moveCommands, matrixSize, playerRow, playerCol);
            } else {
                playerCol = movement(moveCommands, matrixSize, playerRow, playerCol);
            }

            switch (field[playerRow][playerCol]) {
                case 'B':

                    if (moveCommands.equals("up") || moveCommands.equals("down")) {
                        playerRow = movement(moveCommands, matrixSize, playerRow, playerCol);
                    } else {
                        playerCol = movement(moveCommands, matrixSize, playerRow, playerCol);
                    }
                    break;
                case 'T':
                    playerCol = movement("left", matrixSize, playerRow, playerCol);
                    break;
                case 'F':
                    System.out.println("Well done, the player won first place!");
                    field[playerRow][playerCol] = 'P';
                    printMatrix(field);
                    return;
            }
        }
        System.out.println("Oh no, the player got lost on the track!");
        field[playerRow][playerCol] = 'P';
        printMatrix(field);
    }

    private static void printMatrix(char[][] field) {
        Arrays.stream(field).map(row -> Arrays.toString(row).replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "")).forEach(System.out::println);
    }

    private static int movement(String moveCommands, int matrixSize, int playerRow, int playerCol) {

        switch (moveCommands) {
            case "up":

                if (playerRow - 1 == -1) {
                    return matrixSize - 1;
                } else {
                    return playerRow - 1;
                }
            case "down":

                if (playerRow + 1 == matrixSize) {
                    return 0;
                } else {
                    return playerRow + 1;
                }
            case "left":

                if (playerCol - 1 == -1) {
                    return matrixSize - 1;
                } else {
                    return playerCol - 1;
                }
            case "right":

                if (playerCol + 1 == matrixSize) {
                    return 0;
                } else {
                    return playerCol + 1;
                }
        }
        return -1;
    }
}
