package backtracking;

public class BasicArray {
    public static void basicBacktrack(int arr[],int n,int i){
        if(i == n){
            return;
        }
        arr[i] = i+1;
        basicBacktrack(arr, n, i+1);
        // arr[i-1] = arr[i-1]-2; the mistake was i thought when we return the value of i will be 5 (we get index out of bounds)  but as i we hit return the stakc will deleted we come to next level where the value of i is 4
        arr[i] = arr[i]-2;
    }
    public static void main(String[] args) {
        int n = 5;
        int arr [] = new int[n];
        basicBacktrack(arr,n,0);
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
