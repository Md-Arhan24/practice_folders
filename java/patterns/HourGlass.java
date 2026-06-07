
import java.util.Scanner;

public class HourGlass {
    public static void printHourGlass(int n){
        for(int i = 0;i < n;i++){
            for(int j = 1;j <= i;j++){
                System.out.print(" ");
            }
            for(int j = i+1;j <=n;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        for(int i = 1;i <=n-1;i++){
            for(int j = 1;j < n-i;j++){
                System.out.print(" ");
            }
            for(int j = n-i;j <= n;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printHourGlass(n);
        // System.out.println("1 2 3 4 5 6 7 ");
        // System.out.println(" 2 3 4 5 6 7 ");
        // System.out.println("  3 4 5 6 7");
    }
}
