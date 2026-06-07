public class Assingment {
    public static void bubbleSortReverse(int arr[]){
        //select the max element and swap it last
        for(int i = 0;i < arr.length;i++){
            for(int j = 1;j < arr.length;j++){
                if(arr[j] > arr[j-1]){
                    int swap = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = swap;
                }
            }
            // print(arr);
        }
        print(arr);
    }

    public static void selectionSortReverse(int arr[]){
        for(int i = 0;i < arr.length-1;i++){
            int small = i;
            for(int j = 1+i;j < arr.length;j++){
                if(arr[small] < arr[j]){
                    small = j;
                }
            }
           int temp = arr[small];
           arr[small] = arr[i];
           arr[i] = temp;
            
        }
        print(arr);
    }

    public static void insertionSortReverse(int arr[]){
        //divide array two part sorted an unsorted , the pick elemet and put it in sorted part
        for(int i = 1;i < arr.length;i++){
            int key = arr[i];
            int j = i-1;
            while(j >=0 && arr[j] > key ){
                //previous elements swap with it after element
                arr[j+1] = arr[j];
                arr[j] = key;
                j--;
                print(arr);
            }
        }
        print(arr);
    }
    
    public static void countSortReverse(int arr[]){
        //make count of every element and then print as per the count
        //to decide the length of count array we have to take its max element
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length;i++){
            max = Math.max(max,arr[i]);
        }

        //count array
        int count [] = new int [max+1];//considering 0 as element so taking +1
        for(int i = 0;i < arr.length;i++){
            count[arr[i]]++;
        }

        //print as per the count
        for(int i = count.length-1;i > 0;i--){
            while(count[i] > 0){
                System.out.print(i+" ");
                count[i]--;
            }

        }

    }

    public static void print(int arr[]){
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        //the question is use bubble sort,selection sort,insertion sort and count sort to sort the
        //given array in decending order.
        int arr[] = {3,6,2,1,8,8};
        // bubbleSortReverse(arr);
        // selectionSortReverse(arr);
        // insertionSortReverse(arr);
        countSortReverse(arr);
    }
}
