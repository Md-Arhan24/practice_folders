class SelectionSort{
    public static void selectionSort(long arr []){
        //here we first take the index of minimum
        //the swap is once outside of inner loop
        for(int i = 0;i < arr.length;i++){
            int minIndex = i;
            for(int j = i+1;j < arr.length;j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            long temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void printarray(long arr []){
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        long arr [] = {498357983L , 3498739L,39859284L};
        selectionSort(arr);
        printarray(arr);
    }
}