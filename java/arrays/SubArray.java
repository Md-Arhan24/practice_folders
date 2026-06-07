import java.util.*;
public class SubArray {
    public static void printSubArray(int arr[]) {
        int sum = 0;
        int kadans[] = new int[arr.length];
        int maxsum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] + sum > 0) {
                kadans[i] = arr[i] + sum;
                sum += arr[i];
                if (maxsum < sum) {
                    maxsum = sum;
                }
            } else {
                kadans[i] = 0;
            }

        }

        System.out.println(maxsum);
    }

    public static void kadansByShardha(int arr[]){
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for(int i = 0;i < arr.length;i++){
            cs = cs + arr[i];
            if(cs < 0){
                cs = 0;
            }
            ms = Math.max(cs,ms);
        }
        System.out.println(ms);
    }
    public static void main(String[] args) {
        int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        // printSubArray(arr);
        // kadansByShardha(arr);
       int ar [] = {-3,-1,-5};
    //    for(int i = 0;i < ar.length-1;i++){
    //     if(ar[i] < ar[i+1]){
           
    //         int temp = ar[i];
    //         ar[i] = ar[i+1];
    //         ar[i+1] = temp;
    //     }
    //    }
       
       Arrays.sort(ar);
        for(int i = 0;i < ar.length;i++){
        System.out.println(ar[i]);
       }
    }
}