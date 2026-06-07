package arrays;

public class BiggestInArray {
     public static int largestElement(int arr[]){
	int biggest = 0;
	for(int i = 0;i< arr.length;i++){
		if(arr[i] > biggest){
			biggest = arr[i];
			}
		}
	return biggest;
	}
    public static void main(String[] args) {

        int arr[] = { 6, 7, 8, 43, 34, 54, 33 ,99 };

        int big = largestElement(arr);
        System.out.println("the biggest number in array is :" + big);
    }
}
