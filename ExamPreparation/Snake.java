package ExamPreparation;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        char[][] territory = new char[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            char[] row = scanner.nextLine().toCharArray();
            territory[i] = row;
        }
        int snakeRow = -1;
        int snakeCol = -1;

        for (int row = 0; row < matrixSize; row++) {

            for (int col = 0; col < matrixSize; col++) {

                if (territory[row][col] == 'S') {
                    snakeRow = row;
                    snakeCol = col;
                    territory[snakeRow][snakeCol] = '.';
                }
            }
        }

        int foodEaten = 0;
        boolean gameOver = false;

        while (true) {
            String moveCommands = scanner.nextLine();

            switch (moveCommands) {
                case "up":

                    if (snakeRow - 1 != -1) {
                        snakeRow--;
                    } else {
                        gameOver = true;
                    }
                    break;
                case "down":

                    if (snakeRow + 1 < matrixSize) {
                        snakeRow++;
                    } else {
                        gameOver = true;
                    }
                    break;
                case "left":

                    if (snakeCol - 1 != -1) {
                        snakeCol--;
                    } else {
                        gameOver = true;
                    }
                    break;
                case "right":

                    if (snakeCol + 1 < matrixSize) {
                        snakeCol++;
                    } else {
                        gameOver = true;
                    }
                    break;
            }

            if (gameOver) {
                System.out.println("Game over!");
                System.out.println("Food eaten: " + foodEaten);
                printMatrix(territory);
                return;
            }

            if (territory[snakeRow][snakeCol] == '*') {
                foodEaten++;
                territory[snakeRow][snakeCol] = '.';
            } else if (territory[snakeRow][snakeCol] == 'B') {
                territory[snakeRow][snakeCol] = '.';

                for (int row = 0; row < territory.length; row++) {

                    for (int col = 0; col < territory[row].length; col++) {

                        if (territory[row][col] == 'B') {
                            snakeRow = row;
                            snakeCol = col;
                            territory[snakeRow][snakeCol] = '.';
                        }
                    }
                }
            } else {
                territory[snakeRow][snakeCol] = '.';
            }

            if (foodEaten >= 10) {
                System.out.println("You won! You fed the snake.");
                System.out.println("Food eaten: " + foodEaten);
                territory[snakeRow][snakeCol] = 'S';
                printMatrix(territory);
                return;
            }
        }
    }

    private static void printMatrix(char[][] territory) {

        for (char[] chars : territory) {

            for (char symbol : chars) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
