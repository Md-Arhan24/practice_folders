import java.util.Scanner;
public class ArrayGame{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
            if(arr[0] == 0 && arr[n-1] == 0){
                System.out.println("Bob");
            }else{
                System.out.println("Alice");
            }
        }
    }
}