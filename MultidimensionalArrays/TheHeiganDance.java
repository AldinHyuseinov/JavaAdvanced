package MultidimensionalArrays;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double dmgPerTurn = Double.parseDouble(scanner.nextLine());
        int[][] chamber = new int[15][15];
        int playerHp = 18500;
        double bossHp = 3000000;
        int playerRow = 7;
        int playerCol = 7;
        boolean cloud = false;
        boolean bossDead = false;
        boolean playerDead = false;
        String causeOfDeath = "";

        while (true) {
            String[] input = scanner.nextLine().split("\\s+");
            int spellRow = Integer.parseInt(input[1]);
            int spellCol = Integer.parseInt(input[2]);
            bossHp -= dmgPerTurn;

            if (bossHp <= 0) {
                System.out.println("Heigan: Defeated!");
                bossDead = true;

                if (cloud) {
                    playerHp -= 3500;
                }

                if (playerHp <= 0) {
                    System.out.println("Player: Killed by Plague Cloud");
                    playerDead = true;
                }
                break;
            } else {
                dmgArea(chamber, spellRow, spellCol);
            }

            if (chamber[playerRow][playerCol] == 1) {

                if (playerRow - 1 >= 0 && chamber[playerRow - 1][playerCol] != 1) {
                    playerRow--;
                } else if (playerCol + 1 < 15 && chamber[playerRow][playerCol + 1] != 1) {
                    playerCol++;
                } else if (playerRow + 1 < 15 && chamber[playerRow + 1][playerCol] != 1) {
                    playerRow++;
                } else if (playerCol - 1 >= 0 && chamber[playerRow + 1][playerCol - 1] != 1) {
                    playerCol--;
                } else {

                    if (cloud) {
                        playerHp -= 3500;
                        cloud = false;
                    }

                    if (input[0].equals("Cloud")) {
                        playerHp -= 3500;
                        cloud = true;
                    } else {
                        playerHp -= 6000;
                    }
                }
            }

            if (playerHp <= 0) {
                causeOfDeath = input[0];
                playerDead = true;
                break;
            }
            chamber = new int[15][15];
        }

        if (bossDead && !playerDead) {
            System.out.println("Player: " + playerHp);
        } else if (!bossDead) {
            System.out.printf("Heigan: %.2f%n", bossHp);

            if (causeOfDeath.equals("Cloud")) {
                System.out.println("Player: Killed by Plague Cloud");
            } else {
                System.out.println("Player: Killed by " + causeOfDeath);
            }
        }
        System.out.println("Final position: " + playerRow + ", " + playerCol);
    }

    private static void dmgArea(int[][] chamber, int spellRow, int spellCol) {

        for (int row = spellRow - 1; row <= spellRow + 1; row++) {

            if (row >= 0 && row < 15) {

                for (int col = spellCol - 1; col <= spellCol + 1; col++) {

                    if (col >= 0 && col < 15) {
                        chamber[row][col] = 1;
                    }
                }
            }
        }
    }
}
