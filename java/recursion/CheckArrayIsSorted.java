public class CheckArrayIsSorted{
    public static boolean isSorted(int arr[],int i){
        //base case
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] < arr[i+1]){
            return isSorted(arr, i+1);
        }
         return false;
        

    }
    public static void main(String[] args) {
        int arr[] = {1,2,399,99999,99999999,3};
        System.out.println(isSorted(arr,0));
    }
}