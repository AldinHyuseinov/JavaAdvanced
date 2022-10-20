package ExamPreparation;

import java.util.Scanner;

public class Bee {
    private static boolean beeIsInTerritory = true;
    private static int flowerCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] territory = new char[size][size];
        int[] beePosition = new int[2];

        for (int i = 0; i < size; i++) {
            String row = scanner.nextLine();

            if (row.contains("B")) {
                beePosition[0] = i;
                beePosition[1] = row.indexOf("B");
            }
            territory[i] = row.toCharArray();
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            switch (command) {
                case "up":
                    moveBee(territory, beePosition, -1, 0);
                    break;
                case "down":
                    moveBee(territory, beePosition, 1, 0);
                    break;
                case "left":
                    moveBee(territory, beePosition, 0, -1);
                    break;
                case "right":
                    moveBee(territory, beePosition, 0, 1);
                    break;
            }

            if (!beeIsInTerritory) {
                System.out.println("The bee got lost!");
                territory[beePosition[0]][beePosition[1]] = '.';
                break;
            }
            command = scanner.nextLine();
        }

        if (flowerCount >= 5) {
            System.out.println("Great job, the bee manage to pollinate " + flowerCount + " flowers!");
        } else {
            System.out.println("The bee couldn't pollinate the flowers, she needed " + (5 - flowerCount) + " flowers more");
        }

        for (char[] symbols : territory) {

            for (char symbol : symbols) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static void moveBee(char[][] territory, int[] beePosition, int rowChange, int colChange) {
        int[] nextBeePosition = {beePosition[0] + rowChange, beePosition[1] + colChange};

        if (!isInsideTerritory(territory, nextBeePosition[0], nextBeePosition[1])) {
            beeIsInTerritory = false;
            return;
        }

        boolean bonusFound = false;

        if (territory[nextBeePosition[0]][nextBeePosition[1]] == 'f') {
            flowerCount++;
        } else if (territory[nextBeePosition[0]][nextBeePosition[1]] == 'O') {
            bonusFound = true;
        }

        territory[beePosition[0]][beePosition[1]] = '.';
        territory[nextBeePosition[0]][nextBeePosition[1]] = 'B';
        beePosition[0] = nextBeePosition[0];
        beePosition[1] = nextBeePosition[1];

        if (bonusFound) {
            moveBee(territory, beePosition, rowChange, colChange);
        }
    }

    private static boolean isInsideTerritory(char[][] territory, int beeRow, int beeCol) {
        return beeRow >= 0 && beeRow < territory.length && beeCol >= 0 && beeCol < territory[beeRow].length;
    }
}
