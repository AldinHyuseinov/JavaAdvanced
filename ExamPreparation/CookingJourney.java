package ExamPreparation;

import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        char[][] pastryShop = new char[matrixSize][matrixSize];
        int[] myPosition = new int[2];

        for (int i = 0; i < matrixSize; i++) {
            String row = scanner.nextLine();
            int index = row.indexOf("S");

            if (index != -1) {
                myPosition[0] = i;
                myPosition[1] = index;
            }
            pastryShop[i] = row.toCharArray();
        }

        pastryShop[myPosition[0]][myPosition[1]] = '-';
        int money = 0;
        boolean hasDisappeared = false;

        while (money < 50) {
            String moveCommand = scanner.nextLine();

            switch (moveCommand) {
                case "up":

                    if (myPosition[0] - 1 == -1) {
                        hasDisappeared = true;
                    } else {
                        myPosition[0]--;
                    }
                    break;
                case "down":

                    if (myPosition[0] + 1 == matrixSize) {
                        hasDisappeared = true;
                    } else {
                        myPosition[0]++;
                    }
                    break;
                case "left":

                    if (myPosition[1] - 1 == -1) {
                        hasDisappeared = true;
                    } else {
                        myPosition[1]--;
                    }
                    break;
                case "right":

                    if (myPosition[1] + 1 == matrixSize) {
                        hasDisappeared = true;
                    } else {
                        myPosition[1]++;
                    }
                    break;
            }

            if (hasDisappeared) {
                System.out.println("Bad news! You are out of the pastry shop.");
                System.out.println("Money: " + money);
                printMatrix(pastryShop);
                return;
            }

            if (pastryShop[myPosition[0]][myPosition[1]] >= '0' && pastryShop[myPosition[0]][myPosition[1]] <= '9') {
                money += pastryShop[myPosition[0]][myPosition[1]] - '0';
                pastryShop[myPosition[0]][myPosition[1]] = '-';
            } else if (pastryShop[myPosition[0]][myPosition[1]] == 'P') {
                pastryShop[myPosition[0]][myPosition[1]] = '-';

                for (int row = 0; row < matrixSize; row++) {

                    for (int col = 0; col < matrixSize; col++) {

                        if (pastryShop[row][col] == 'P') {
                            pastryShop[row][col] = '-';
                            myPosition[0] = row;
                            myPosition[1] = col;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("Good news! You succeeded in collecting enough money!");
        System.out.println("Money: " + money);
        pastryShop[myPosition[0]][myPosition[1]] = 'S';
        printMatrix(pastryShop);
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