import java.util.ArrayList;
public class HeapImplement {
    static class Heap{
       ArrayList<Integer> arr = new ArrayList<>();

        //insert in heap
        public void add(int ele){
            //first add the ele at arraylist
            arr.add(ele);
            int childIdx = arr.size()-1;
            int parentIdx = (childIdx-1)/2;
            while(arr.get(childIdx) > arr.get(parentIdx)){
                int temp = arr.get(childIdx);
                arr.set(childIdx, arr.get(parentIdx));
                arr.set(parentIdx,temp);
                childIdx = parentIdx;
                parentIdx = (childIdx-1)/2;
            }
        }
        //is empty
        public boolean isEmpty(){
            return arr.size() == 0;
        }

        //peek
        public int peek(){
            if(arr.size() == 0)return -1;
            return arr.get(0);
        }

        //delete the node
        public int remove(){
            //heap is empty
            if(arr.size() == 0){
                return -1;
            }

            //step 1 , swap the first with last
            int data = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,data);

            //step 2 : remove the last
            arr.remove(arr.size()-1);

            //heapfiy
            heapfiy(0);//first node index is 0
            return data;
            
        }
        //heapify
        private void heapfiy(int i){
            //left and right ele
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;//we consider that our root is min ,so taken as i

            //check whether left is in range or not and check does mid index is greater then left, if yes then make minIdx as left, so that it may point to less
            if(left < arr.size() && arr.get(minIdx) < arr.get(left)){
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) < arr.get(right)){
                
                minIdx = right;
            }

            //then swap when midIdx != i,because if there is no change then why to swap
            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx,temp);

                //check for my child distubed or not
                heapfiy(minIdx);
            }


        }
    }
    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(1);
        pq.add(-1);
        pq.add(10);
        pq.add(3);
        while(!pq.isEmpty()){
            System.out.print(pq.peek()+" ");
            pq.remove();
        }
        
    }
}
