public class Nqueens {
    //is safe check for the current queen position is safe to place
    public static boolean isSafe(char board[][],int row,int col){
        
        //check vertically up
         for(int i = 0;i < row;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
         }

         //diagonal left up
        //  for(int i = 0;i < row;i++){
        //     if(board[i][i] == 'Q'){
        //         return false;
        //     }
        //  }
        int r = row;
        int j = col;
        while(r >= 0 && j <= board.length-1){
            if(board[r][j] == 'Q'){
                return false;
            }
            r--;
            j++;
        }

         //vertically right up
        //  for(int j = board.length-1;j >=row;j--){
        //     if(board[j][j] == 'Q'){
        //         return false;
        //     }
        //  }
         r = row;
        j = col;
        while(r >= 0 && j >= 0 ){
            if(board[r][j] == 'Q'){
                return false;
            }
            r--;
            j--;
        }
         return true;
    }

    public static void printBoard(char Board[][]) {
        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board.length; j++) {
                System.out.print(Board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("______");
    }

    public static void nQueens(char arr[][], int row) {
        if (row == arr.length) {
            printBoard(arr);
            return;
        }

        // first we check for this
        for (int j = 0; j < arr.length; j++) {
            if (isSafe(arr, row, j)) {

                // make constant for row and call for belwo one
                arr[row][j] = 'Q';//
                nQueens(arr, row + 1);// called for other , so we dont have to pass j , we have to pass row+1 to make
                                      // sure we sit n queen in next row
                arr[row][j] = '.';// as we come back or backtrack we have to remove it form that place and should
                                  // sit at other place because we dont want two queens to sit in same row.
            }

        }
    }

    public static void main(String[] args) {
        int n = 1;
        char arr[][] = new char[n][n];
        // intilizing part
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = '.';
            }
        }

        // call for n queens
        // 0 is starting index
        nQueens(arr, 0);
    }
}
