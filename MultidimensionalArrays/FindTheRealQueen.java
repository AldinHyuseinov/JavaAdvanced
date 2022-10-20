package MultidimensionalArrays;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] chessboard = new String[8][8];

        for (int i = 0; i < 8; i++) {
            String[] input = scanner.nextLine().split(" ");
            chessboard[i] = input;
        }

        for (int row = 0; row < 8; row++) {

            for (int col = 0; col < 8; col++) {

                if (chessboard[row][col].equals("q")) {

                    if (horizontalCheck(chessboard, row, col)) {

                    }
                }
            }
        }
    }

    public static boolean horizontalCheck(String[][] chessboard, int row, int column) {

        if (column == 7) {
            return true;
        }

        for (int i = column; i < 8; i++) {

            if (chessboard[row][i].equals("q")) {
                return false;
            }
        }
        return true;
    }
}
