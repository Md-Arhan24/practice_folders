package searching;

public class BinarySearch {
    public static void binarySearch(int arr[],int tar){
        int low = 0;
        int high = arr.length-1;
        int mid;
        int count = 0;

        while(low <= high){
             mid = (low + high)/2;
            if(arr[mid] == tar){
                System.out.print("true");
                break;
            }
            else if(arr[mid] < tar){
                low = mid+1;
            }
            else if(arr[mid] > tar){
                high = mid -1;
            }
            System.out.print(count++);
        }
    }
    public static void main(String[] args) {
        int arr [] = {1,2,5,8,10,18};
        // binarySearch(arr,18);
        System.out.println(9%3 == 0);
    }
}
