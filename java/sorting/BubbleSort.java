public class BubbleSort{
    public static void bubblesort(long [] arr){
        //bubble sort - highest bubble(number ) comes first
        for(int i = 0,swap = 0;i < arr.length;i++){
            
            for(int j = 0;j < arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    swap ++;
                    long temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
            if(swap == 0){
                break;
            }
        }

    }
    public static void bubbleSort_optimized(long arr[]){
        for(int i = 0;i < arr.length;i++){
            boolean isSorted = false;//we are cheking every times is array sorted or not
            for(int j = 0;j < arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    long temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSorted = true;
                }

            }
            if(!isSorted){
                break;
            }
        }
    }
    public static void printArray(long [] arr){
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i] +" ");
        }
        
    }
    public static void main(String [] args){
        long arr [] = {4 ,33, 98, 33333333 ,293839494, 90990909990L };
        // bubblesort(arr);
        bubbleSort_optimized(arr);
        printArray(arr);
    }
}