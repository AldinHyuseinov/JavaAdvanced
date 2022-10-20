package ExamPreparation;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int matrixSize = Integer.parseInt(scanner.nextLine());
        char[][] city = new char[matrixSize][matrixSize];
        int[] playerPosition = new int[2];

        for (int i = 0; i < matrixSize; i++) {
            String row = scanner.nextLine();
            int index = row.indexOf("P");

            if (index != -1) {
                playerPosition[0] = i;
                playerPosition[1] = index;
            }
            city[i] = row.toCharArray();
        }
        city[playerPosition[0]][playerPosition[1]] = '-';

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            int[] enemyPosition = {Integer.parseInt(input[1]), Integer.parseInt(input[2])};
            city[enemyPosition[0]][enemyPosition[1]] = 'S';

            switch (input[0]) {
                case "up":
                    if (playerPosition[0] - 1 > -1) {
                        playerPosition[0]--;
                    }
                    break;
                case "down":
                    if (playerPosition[0] + 1 < matrixSize) {
                        playerPosition[0]++;
                    }
                    break;
                case "left":
                    if (playerPosition[1] - 1 > -1) {
                        playerPosition[1]--;
                    }
                    break;
                case "right":
                    if (playerPosition[1] + 1 < matrixSize) {
                        playerPosition[1]++;
                    }
                    break;
            }
            energy--;

            if (city[playerPosition[0]][playerPosition[1]] == 'H') {
                city[playerPosition[0]][playerPosition[1]] = '-';
                System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
                printMatrix(city);
                return;
            } else if (city[playerPosition[0]][playerPosition[1]] == 'S') {
                energy -= 2;
                city[playerPosition[0]][playerPosition[1]] = '-';
            }

            if (energy <= 0) {
                city[playerPosition[0]][playerPosition[1]] = 'X';
                System.out.println("Paris died at " + playerPosition[0] + ";" + playerPosition[1] + ".");
                printMatrix(city);
                return;
            }
        }
    }

    private static void printMatrix(char[][] matrix) {

        for (char[] symbols : matrix) {

            for (char symbol : symbols) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
