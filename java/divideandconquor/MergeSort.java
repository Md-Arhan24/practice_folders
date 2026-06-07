package divideandconquor;

public class MergeSort {
    public static void MergeSort(int arr[],int si,int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei-si)/2;
        MergeSort(arr, si, mid);
        MergeSort(arr, mid+1, ei);
        merge(arr,si,mid,ei);
        
    }
    public static void merge(int arr[],int si,int mid,int ei){
        //create a temp array of size ei-si+1
        int temp [] = new int[ei-si+1];
        int k = 0;
        int i = si;
        int j = mid+1;

        while(i <=mid && j <=ei){
            //insert smallest ones
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
            

        }
        //some times the elements will be remain
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= ei){
            temp[k++] = arr[j++];
        }

        for(int l = 0,m = si;l < temp.length;l++,m++){
            arr[m] = temp[l];
        }
    }
    public static void main(String[] args) {
        int arr [] = {1,8,63,33,12,2};
        //some times you may pass arr.length but you have to pass arr.length-1
        MergeSort(arr,0,arr.length-1);
        PrintArr(arr);
    }
    public static void PrintArr(int arr[]){
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
