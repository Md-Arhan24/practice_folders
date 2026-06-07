import java.util.*;
public class Table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int h = sc.nextInt();
            int l = sc.nextInt();
            int arr[] = new int [n];
            for(int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(getCount(arr,h,l,n));

        }
       

    }
    public static int getCount(int arr[],int h,int l,int size){
        if(h == 1 && l == 1 && size == 2){
            return 1;
        }
      
        int lessH = 0,lessL = 0;
        for(int i = 0;i < size;i++){
            if(arr[i] <= h){
                lessH++;
            }
            if(arr[i] <= l){
                lessL++;
            }
           
        }
        return Math.min(lessH, lessL)/2;
}
}
