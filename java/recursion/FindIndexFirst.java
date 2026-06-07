public class FindIndexFirst {
    public static int getIndex(int arr[],int i,int k){
       
         if(i == arr.length){
            return -1;
        }
        if(arr[i] == k){
            return i;
        }
       
        return getIndex(arr, i+1, k);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println(getIndex(arr,0,5));
    }
}
