public class QuickSort{
    public static void printArray(int arr[]){
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void quickSort(int arr[],int si,int ei){
        //base case
        if(si >= ei){
            return;
        }

        //partition
        int pidx = partition(arr,si,ei);
        quickSort(arr, si, pidx-1);//left part
        quickSort(arr, pidx+1, ei);//right part
       
    }
    
    public static int partition(int arr[],int si,int ei){
        int pivot = arr[ei];//last element
        int i = si-1;
        for(int j = si;j < ei;j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //at last swaping pivot
        i++;
        int temp = pivot;//taking its value
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }
    public static void main(String[] args) {
        int arr [] = {6,3,9,8,2,5};
        quickSort(arr,0,arr.length-1);
        printArray(arr);
    }
}