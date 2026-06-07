public class MergeSort {
    public static void mergersort(int arr[],int si,int ei){
        //base case - till our start index = or grater than end index
        if(si >= ei){
            return;//we dont return any thing just simply return
        }
        //extract the mid
        int mid = si + (ei - si)/2; //we can also write (si+ei)/2 but if large value came our int wont handle it
        System.out.println("above call");
        mergersort(arr, si, mid);//divide array till mid which is left part
        System.out.println("below 1 call and value of mid " + (mid+1) + " ei is "+ ei);
        mergersort(arr, mid+1, ei);//divide array from mid to end right part
        //call for merge
        System.out.println("below 2 call");
        System.out.println("below 2 call and value of si is "+ si +" mid " + (mid) + " ei is "+ ei);
        merge(arr,si,mid,ei);
        System.out.println("below 3 call");
        
    }
    public static void merge(int arr[],int si,int mid, int ei){
        //create a temp array 
        int temp [] = new int[ei - si +1]; //we sub the ending index to start index and +1  

        //intilizing values
        int i = 0;//to iterate temp array
        int j = si;//to iterate left sorted array
        int k = mid+1;//to iterate right sorted array

        //while we have completed the iteration of left and right sorted array
        while(j <= mid && k <= ei){
            //checking the value of both sub array
            if(arr[j] < arr[k]){
                temp[i] = arr[j];
                j++;
            }else{
                temp[i] = arr[k];
                k++;
            }
            //as i will increse in either cases
            i++;
        }

        //for remaining left
        while(j <= mid){
            temp[i++] = arr[j++];
        }

        //for remaing right
         while(k <= ei){
            temp[i++] = arr[k++];
        }

        for(int l= 0, z = si; l< temp.length;l++,z++){
            arr[z] = temp[l]; 
        }
        printarr(temp);
        
    }
    public static void printarr(int arr[]){
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr [] = {6,3,9,5,2,8};
        mergersort(arr,0,arr.length-1);
        // printarr(arr);
    }
}
