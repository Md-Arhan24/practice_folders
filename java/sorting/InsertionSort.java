public class InsertionSort{
    public static void insertionsort(int arr []){

        //start form 1 , because 0 th element is consider as sort
        for(int i = 1;i < arr.length;i++){
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > key){
                // int temp = arr[i];
                // arr[i] = arr[i-1];
                // arr[i-1] = arr[i];

                // arr[i] = arr[i] ^ arr[j];
                // arr[j] = arr[i] ^ arr[j];
                // arr[i] = arr[i] ^ arr[j];

                arr[j+1] = arr[j];
                arr[j] = key;
                j--;

            }
        }
        printarr(arr);
    }
    public static void printarr(int arr[]){
        for(int i= 0;i < arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    public static void main(String [] args){
        int arr [] = {8,7,1,2,4};
        insertionsort(arr);
    }
}