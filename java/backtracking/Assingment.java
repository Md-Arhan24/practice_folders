import java.util.*;
public class Assingment{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the n value");
        int n = sc.nextInt();
        getTheKnightMoves(n);

    }
    public static void getTheKnightMoves(int n){
        int board [][]  = new int [n][n];
        boolean boardVisits [][] = new boolean[n][n];
        //to know that i have made the correct choices i have to make the fillTheMoves function to boolean
        if(fillTheMoves(board,0,0,0,boardVisits)){
            System.out.println("solution exists");
            printBoard(board);
        }else{
            System.out.println("solution wont exists......, try another number");
        }
    }
    public static boolean fillTheMoves(int board[][],int row,int col,int iniVal,boolean boardVisits[][]){
        //base case
        if(row < 0 || row >= board.length || col < 0 || col >= board.length || boardVisits[row][col]){
            return false;
        }

        board[row][col] = iniVal;
        boardVisits[row][col] = true;

        if(iniVal == (board.length * board.length) - 1){
            return true;
        }
        //8 choices per box
        if(fillTheMoves(board, row-2, col+1, iniVal+1,boardVisits)) return true;
       if(fillTheMoves(board, row-1, col+2, iniVal+1,boardVisits)) return true;
       if(fillTheMoves(board, row+1, col+2, iniVal+1,boardVisits)) return true;
       if(fillTheMoves(board, row+2, col+1, iniVal+1,boardVisits)) return true;
       if(fillTheMoves(board, row+2, col-1, iniVal+1,boardVisits)) return true;
       if(fillTheMoves(board, row+1, col-2, iniVal+1,boardVisits)) return true;
       if(fillTheMoves(board, row-1, col-2, iniVal+1,boardVisits)) return true;
       if(fillTheMoves(board, row-2, col-1, iniVal+1,boardVisits)) return true;
       
        boardVisits[row][col] = false;
        return false;
    }
    public static void printBoard(int [][] board){
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board.length;j++){
                 System.out.printf("%3d ", board[i][j]);
            }
            System.out.println();
        }
    }
}