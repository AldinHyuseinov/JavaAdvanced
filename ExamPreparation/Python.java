package ExamPreparation;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        char[][] screen = new char[matrixSize][matrixSize];
        String[] moveCommands = scanner.nextLine().split(", ");

        for (int row = 0; row < matrixSize; row++) {
            String[] line = scanner.nextLine().split(" ");

            for (int col = 0; col < matrixSize; col++) {
                screen[row][col] = line[col].charAt(0);
            }
        }

        int pythonRow = -1;
        int pythonCol = -1;

        for (int row = 0; row < matrixSize; row++) {

            for (int col = 0; col < matrixSize; col++) {

                if (screen[row][col] == 's') {
                    pythonRow = row;
                    pythonCol = col;
                    break;
                }
            }
        }

        int foodLeft = 0;

        for (int row = 0; row < matrixSize; row++) {

            for (int col = 0; col < matrixSize; col++) {

                if (screen[row][col] == 'f') {
                    foodLeft++;
                }
            }
        }
        int pythonLength = 1;

        for (String moveCommand : moveCommands) {

            switch (moveCommand) {
                case "up":

                    if (pythonRow - 1 == -1) {
                        pythonRow = matrixSize - 1;
                    } else {
                        pythonRow--;
                    }
                    break;
                case "down":

                    if (pythonRow + 1 == matrixSize) {
                        pythonRow = 0;
                    } else {
                        pythonRow++;
                    }
                    break;
                case "left":

                    if (pythonCol - 1 == -1) {
                        pythonCol = matrixSize - 1;
                    } else {
                        pythonCol--;
                    }
                    break;
                case "right":

                    if (pythonCol + 1 == matrixSize) {
                        pythonCol = 0;
                    } else {
                        pythonCol++;
                    }
                    break;
            }

            if (screen[pythonRow][pythonCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }

            if (screen[pythonRow][pythonCol] == 'f') {
                pythonLength++;
                foodLeft--;

                if (foodLeft == 0) {
                    System.out.println("You win! Final python length is " + pythonLength);
                    return;
                }
            }
        }

        System.out.println("You lose! There is still " + foodLeft + " food to be eaten.");
    }
}
