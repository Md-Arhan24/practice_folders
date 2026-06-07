import java.util.Scanner;
public class GetmaxAndmin {
    public static int getMin(int mat [][]){
        int min = Integer.MAX_VALUE;
        int n = mat.length; int m = mat[0].length;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                min = Math.min(min,mat[i][j]);
            }
        }
        return min;
    }
    public static int getMax(int mat [][]){
        int max = Integer.MIN_VALUE;
        int n = mat.length; int m = mat[0].length;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                max = Math.max(max,mat[i][j]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of matrix  n:");
        int n = sc.nextInt();
        System.out.println();
        System.out.print("Enter the size of matrix  m:");
        int m = sc.nextInt();
        
        int mat [][] = new int [n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int min = getMin(mat);
        int max = getMax(mat);
        System.out.println("the min ele is :" + min + " and max is :" +max);
    }
}
