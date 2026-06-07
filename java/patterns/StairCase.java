import java.util.Scanner;
public class StairCase{
    public static void printStaris(int n){
        int x = 2;
        for(int i = 1;i <=n;i++){
            for(int j = 1;j<=x;j++){
                System.out.print("*"+" ");
            }
            if(i%2 == 0){
                x+=2;
            }
            System.out.println();
        }
    }
    //optimized approach
    public static void printStarisOptimized(int n){
        String str ="* * ";
        for(int i = 1;i <=n;i++){
            System.out.println(str);
            if(i%2 == 0){
                str+="* * ";
                
            }
        }
       

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        // printStaris(n);
        printStarisOptimized(n);
    }

}