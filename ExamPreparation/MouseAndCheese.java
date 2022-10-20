package ExamPreparation;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        char[][] territory = new char[matrixSize][matrixSize];
        int[] mousePosition = new int[2];

        for (int i = 0; i < matrixSize; i++) {
            String row = scanner.nextLine();
            int index = row.indexOf("M");

            if (index != -1) {
                mousePosition[0] = i;
                mousePosition[1] = index;
            }
            territory[i] = row.toCharArray();
        }
        territory[mousePosition[0]][mousePosition[1]] = '-';

        String command = scanner.nextLine();
        int cheeseEaten = 0;

        while (!command.equals("end")) {
            int moveMouse = mouseMovement(command, matrixSize, mousePosition);

            if (moveMouse == -1) {
                System.out.println("Where is the mouse?");
                cheesePrint(cheeseEaten);
                printMatrix(territory);
                return;
            }
            assignMousePosition(mousePosition, command, moveMouse);

            if (territory[mousePosition[0]][mousePosition[1]] == 'c') {
                cheeseEaten++;
                territory[mousePosition[0]][mousePosition[1]] = '-';
            } else if (territory[mousePosition[0]][mousePosition[1]] == 'B') {
                moveMouse = mouseMovement(command, matrixSize, mousePosition);
                assignMousePosition(mousePosition, command, moveMouse);
                territory[mousePosition[0]][mousePosition[1]] = '-';
            }
            command = scanner.nextLine();
        }

        territory[mousePosition[0]][mousePosition[1]] = 'M';
        cheesePrint(cheeseEaten);
        printMatrix(territory);
    }

    private static void assignMousePosition(int[] mousePosition, String command, int moveMouse) {

        if (command.equals("up") || command.equals("down")) {
            mousePosition[0] = moveMouse;
        } else {
            mousePosition[1] = moveMouse;
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

    private static void cheesePrint(int cheeseEaten) {

        if (cheeseEaten < 5) {
            System.out.println("The mouse couldn't eat the cheeses, she needed " + (5 - cheeseEaten) + " cheeses more.");
        } else {
            System.out.println("Great job, the mouse is fed " + cheeseEaten + " cheeses!");
        }
    }

    private static int mouseMovement(String moveCommand, int matrixSize, int[] mousePosition) {

        switch (moveCommand) {
            case "up":

                if (mousePosition[0] - 1 == -1) {
                    return -1;
                } else {
                    return mousePosition[0] - 1;
                }
            case "down":

                if (mousePosition[0] + 1 == matrixSize) {
                    return -1;
                } else {
                    return mousePosition[0] + 1;
                }
            case "left":

                if (mousePosition[1] - 1 == -1) {
                    return -1;
                } else {
                    return mousePosition[1] - 1;
                }
            case "right":

                if (mousePosition[1] + 1 == matrixSize) {
                    return -1;
                } else {
                    return mousePosition[1] + 1;
                }
        }
        return -1;
    }
}
