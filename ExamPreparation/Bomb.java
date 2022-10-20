package ExamPreparation;

import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[matrixSize][matrixSize];
        int[] sapperPosition = new int[2];
        String[] moveCommands = scanner.nextLine().split(",");

        for (int i = 0; i < matrixSize; i++) {
            String row = scanner.nextLine().replaceAll(" ", "");
            int indexOfSapper = row.indexOf("s");

            if (indexOfSapper != -1) {
                sapperPosition[0] = i;
                sapperPosition[1] = indexOfSapper;
            }
            field[i] = row.toCharArray();
        }

        int bombCount = 0;

        for (int row = 0; row < matrixSize; row++) {

            for (int col = 0; col < matrixSize; col++) {

                if (field[row][col] == 'B') {
                    bombCount++;
                }
            }
        }

        for (String moveCommand : moveCommands) {

            switch (moveCommand) {
                case "up":

                    if (sapperPosition[0] - 1 > -1) {
                        sapperPosition[0]--;
                    }
                    break;
                case "down":

                    if (sapperPosition[0] + 1 < matrixSize) {
                        sapperPosition[0]++;
                    }
                    break;
                case "left":

                    if (sapperPosition[1] - 1 > -1) {
                        sapperPosition[1]--;
                    }
                    break;
                case "right":

                    if (sapperPosition[1] + 1 < matrixSize) {
                        sapperPosition[1]++;
                    }
                    break;
            }

            if (field[sapperPosition[0]][sapperPosition[1]] == 'B') {
                bombCount--;
                field[sapperPosition[0]][sapperPosition[1]] = '+';
                System.out.println("You found a bomb!");

                if (bombCount <= 0) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (field[sapperPosition[0]][sapperPosition[1]] == 'e') {
                System.out.println("END! " + bombCount + " bombs left on the field");
                return;
            }
        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombCount, sapperPosition[0], sapperPosition[1]);
    }
}
