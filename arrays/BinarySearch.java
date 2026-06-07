package arrays;

import java.util.ArrayList;

public class BinarySearch {
	public static int binarySearch(int key,int arr[]){
		int start = 0, end = arr.length -1;//last index will be -1 of size

		while (start <= end) {
			int mid = start + (end - start) / 2;//best beeause it doesnt extend the limit no array index out of bounds
			System.out.println(mid);
			
			//comparison
			if(arr[mid] == key){
				return mid;
			}
			if(key > arr[mid]){
				//search right
				start = mid + 1;
			}
			else{
				end = mid - 1;
			}
		 
		}
		return -1;
	}
    public static void main(String[] args) {
        int arr[] = { 5, 6, 7, 8, 9, 44, 55, 66, 77 };
       
        System.out.println("the index of key is " + binarySearch(55,arr));

    }
}
