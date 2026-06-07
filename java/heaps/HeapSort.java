import java.util.ArrayList;

public class HeapSort {
   static ArrayList<Integer> arr = new ArrayList<>();

    //step 1 : conver the array to max heap 
    //to convert max heap called heapify for above level
    public static void heapfiy(int i,int size){
        //get left and right
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;

        if(left < size && arr.get(maxIdx) < arr.get(left)){
            maxIdx = left;
        }
        if(right < size && arr.get(maxIdx) < arr.get(right)){
            maxIdx = right;
        }

        if(maxIdx != i){
            //swap maxIdx with i
            int temp = arr.get(i);
            arr.set(i,arr.get(maxIdx));
            arr.set(maxIdx,temp);

            //call for child
            heapfiy(maxIdx,size);
        }

    }
   

    public static void swap(int i,int j){
        int temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }
    public static void main(String[] args) {
        arr.add(19);
        arr.add(1);
        arr.add(87);
        arr.add(90);
        arr.add(76);

        //lets call heapify for above level n/2
        int n = arr.size()-1;
        for(int i = n/2;i >= 0;i--){
            heapfiy(i,n+1);
        }

        //then swap the root with the unsorted element last
        for(int i = n;i >= 0;i--){
            swap(0,i);//first with last
            //call heapify for 0
            heapfiy(0,i);

        }

        //at last print arr
        System.out.println(arr);
        
    }
}
