public class Sudoko {
    public static boolean isSafe(String[][] sudo, int row, int col, String num) {
        // row wise - hrizontally
        for (int i = 0; i < sudo.length; i++) {
            if (sudo[row][i].equals(num)) {
                return false;
            }
        }
        // col wise (vertically)
        for (int i = 0; i < sudo.length; i++) {
            if (sudo[i][col].equals(num)) {
                return false;
            }
        }

        // grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudo[i][j].equals(num)) {
                    return false;
                }
            }
        }
        return true;
    }

    // this blind run and over write if we use void as it cant single that we found
    // first ans so written the correct way is to use boolea
    public static void solvedSudoko(String[][] soduku, int row, int col) {
        // base case
        if (row == 9 && col == 0) {
            print(soduku);
            System.exit(0);
        }

        // start value for row and col
        int nextRow = row, nextCol = col + 1;
        if (nextCol == soduku.length) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // we cant change the existing value
        if (!soduku[row][col].equals(".")) {
            solvedSudoko(soduku, nextRow, nextCol);
        }
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(soduku, row, col, String.valueOf(digit))) {
                soduku[row][col] = String.valueOf(digit);
                solvedSudoko(soduku, nextRow, nextCol);
                soduku[row][col] = ".";

            }

        }

    }

    public static boolean validSudoko(String[][] sudo, int row, int col) {
        if (row == 9 && col == 0) {
            return true;
        }

        // next row and col
        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }
        if (!sudo[row][col].equals(".")) {
            return validSudoko(sudo, nextRow, nextCol);
        }
        for (int i = 1; i <= 9; i++) {
            if (isSafe(sudo, row, col, String.valueOf(i))) {
                sudo[row][col] = String.valueOf(i);
                if (validSudoko(sudo, nextRow, nextCol)) {
                    return true;
                }
                sudo[row][col] = ".";
            }

        }
        return false;
    }

    public static void print(String[][] sudo) {
        for (int i = 0; i < sudo.length; i++) {
            for (int j = 0; j < sudo.length; j++) {
                System.out.print(sudo[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String sudoko[][] = { { "5", "3", ".", ".", "7", ".", ".", ".", "." },
                { "6", ".", ".", "1", "9", "5", ".", ".", "." }, { ".", "9", "8", ".", ".", ".", ".", "6", "." },
                { "8", ".", ".", ".", "6", ".", ".", ".", "3" }, { "4", ".", ".", "8", ".", "3", ".", ".", "1" },
                { "7", ".", ".", ".", "2", ".", ".", ".", "6" }, { ".", "6", ".", ".", ".", ".", "2", "8", "." },
                { ".", ".", ".", "4", "1", "9", ".", ".", "5" }, { ".", ".", ".", ".", "8", ".", ".", "7", "9" } };
        // solvedSudoko(sudoko,0,0);
        validSudoko(sudoko, 0, 0);
        print(sudoko);

    }
}
