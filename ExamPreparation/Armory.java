package ExamPreparation;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        char[][] armory = new char[matrixSize][matrixSize];
        int[] officerPosition = new int[2];

        for (int i = 0; i < matrixSize; i++) {
            String row = scanner.nextLine();
            int index = row.indexOf("A");

            if (index != -1) {
                officerPosition[0] = i;
                officerPosition[1] = index;
            }
            armory[i] = row.toCharArray();
        }

        armory[officerPosition[0]][officerPosition[1]] = '-';
        int profit = 0;
        boolean leftArmory = false;

        profitLoop:
        while (profit < 65) {
            String moveCommand = scanner.nextLine();

            switch (moveCommand) {
                case "up":

                    if (officerPosition[0] - 1 == -1) {
                        leftArmory = true;
                        break profitLoop;
                    } else {
                        officerPosition[0]--;
                    }
                    break;
                case "down":

                    if (officerPosition[0] + 1 == matrixSize) {
                        leftArmory = true;
                        break profitLoop;
                    } else {
                        officerPosition[0]++;
                    }
                    break;
                case "left":

                    if (officerPosition[1] - 1 == -1) {
                        leftArmory = true;
                        break profitLoop;
                    } else {
                        officerPosition[1]--;
                    }
                    break;
                case "right":

                    if (officerPosition[1] + 1 == matrixSize) {
                        leftArmory = true;
                        break profitLoop;
                    } else {
                        officerPosition[1]++;
                    }
                    break;
            }

            if (armory[officerPosition[0]][officerPosition[1]] >= '0' && armory[officerPosition[0]][officerPosition[1]] <= '9') {
                profit += armory[officerPosition[0]][officerPosition[1]] - '0';
                armory[officerPosition[0]][officerPosition[1]] = '-';
            } else if (armory[officerPosition[0]][officerPosition[1]] == 'M') {
                armory[officerPosition[0]][officerPosition[1]] = '-';

                for (int row = 0; row < matrixSize; row++) {

                    for (int col = 0; col < matrixSize; col++) {

                        if (armory[row][col] == 'M') {
                            officerPosition[0] = row;
                            officerPosition[1] = col;
                            armory[row][col] = '-';
                            break;
                        }
                    }
                }
            }
        }

        if (leftArmory) {
            System.out.println("I do not need more swords!");
        } else {
            armory[officerPosition[0]][officerPosition[1]] = 'A';
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.println("The king paid " + profit + " gold coins.");

        for (int row = 0; row < matrixSize; row++) {

            for (int col = 0; col < matrixSize; col++) {
                System.out.print(armory[row][col]);
            }
            System.out.println();
        }
    }
}
