package arrays;

public class ReverseTheArray {
    public static int[] reverse(int arr[]){
        int newarray [] = new int[arr.length];
        for(int i = arr.length - 1,j = 0;i >= 0 &&  j < arr.length;i--,j++){
            newarray[j] = arr[i];
        }
        return newarray;
        }

    

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};

    //    int arr2[] =  reverse(array);

    //    for(int i = 0;i < arr2.length;i++){
    //     System.out.print(arr2[i]);
    //    }

    //best approach - reduce time and space
    for(int start = 0,end = arr.length -1;start <= end;start++,end--){
	    int swap = arr[end];
	    arr[end] = arr[start];
	    arr[start] = swap;
}
    for(int i = 0;i < arr.length;i++){
        System.out.print(arr[i]+ " ");
       }
    }
}

