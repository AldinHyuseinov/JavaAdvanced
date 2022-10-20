package ExamPreparation;

import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        char[][] board = new char[8][8];
        Scanner scanner = new Scanner(System.in);
        int[] whitePawnLocation = new int[2];
        int[] blackPawnLocation = new int[2];

        for (int row = 0; row < board.length; row++) {
            char[] arr = scanner.nextLine().toCharArray();

            for (int col = 0; col < arr.length; col++) {
                board[row][col] = arr[col];

                if (arr[col] == 'w') {
                    whitePawnLocation[0] = row;
                    whitePawnLocation[1] = col;
                } else if (arr[col] == 'b') {
                    blackPawnLocation[0] = row;
                    blackPawnLocation[1] = col;
                }
            }
        }

        boolean isHit = false;

        while (whitePawnLocation[0] != 0 && blackPawnLocation[0] != 7 && !isHit) {

            if (whitePawnLocation[0] - 1 == blackPawnLocation[0] && (whitePawnLocation[1] + 1 == blackPawnLocation[1] || whitePawnLocation[1] - 1 == blackPawnLocation[1])) {
                System.out.println("Game over! White capture on " + findCoordinates(blackPawnLocation[0], blackPawnLocation[1]));
                isHit = true;
            }
            whitePawnLocation[0]--;

            if (blackPawnLocation[0] + 1 == whitePawnLocation[0] && (blackPawnLocation[1] + 1 == whitePawnLocation[1] || blackPawnLocation[1] - 1 == whitePawnLocation[1])) {
                System.out.println("Game over! Black capture on " + findCoordinates(whitePawnLocation[0], whitePawnLocation[1]));
                isHit = true;
            }
            blackPawnLocation[0]++;
        }

        if (!isHit) {

            if (whitePawnLocation[0] == 0) {
                System.out.println("Game over! White pawn is promoted to a queen at " + findCoordinates(whitePawnLocation[0], whitePawnLocation[1]) + ".");
            } else {
                System.out.println("Game over! Black pawn is promoted to a queen at " + findCoordinates(blackPawnLocation[0], blackPawnLocation[1]) + ".");
            }
        }
    }

    private static String findCoordinates(int bRow, int bCol) {
        char[] col = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] row = new char[]{'8', '7', '6', '5', '4', '3', '2', '1'};
        StringBuilder sb = new StringBuilder();
        sb.append(col[bCol]).append(row[bRow]);
        return sb.toString();
    }
}
