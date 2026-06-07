import java.util.Scanner;

public class SpiralMatix {
    public static void printSprial(int mat[][]) {
        int startRow = 0, endRow = mat.length - 1, startCol = 0, endCol = mat[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            // top - here we move colum wise so we have to start form first col
            for (int i = startCol; i <= endCol; i++) {
                System.out.print(mat[startRow][i] + " ");
            }

            // left - here we move row wise so top to down and +1 because we dont want to print the element which is alredy print by before loop
            for (int j = startRow+1; j <= endRow; j++) {
                System.out.print(mat[j][endCol] + " ");
            }
            // bottom - here we move column wise and -1 because we dont want to print element which is already printed by before loop
            for (int j = endCol-1; j >= startCol; j--) {
                //if nXn is odd then we dont want middle ele print twice so
                if(startRow == endRow){
                    break;
                }
                System.out.print(mat[endRow][j] + " ");
            }

            // right
            for (int j = endRow-1; j > startRow; j--) {
                if(startCol == endCol){
                    break;
                }
                System.out.print(mat[j][startCol] + " ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
            
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of matrix  n:");
        int n = sc.nextInt();
        System.out.println();
        System.out.print("Enter the size of matrix  m:");
        int m = sc.nextInt();

        int mat[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        // int mat [] [] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printSprial(mat);
    }
}
