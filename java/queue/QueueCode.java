public class QueueCode{
    static class Queue{
       static int arr[];
       static int rear;
       static int size;

       public Queue(int size){
        arr = new int [size];
        this.size = size;
        rear = -1;
       }
       public static boolean isEmpty(){
        // if(rear == -1){
        //     return true;
        // }
        // return false;
        return rear == -1;
       }

       public static void add(int n){
        //if full we cant dd
        //mistake - number 1
        // if(size == arr.length-1){
        //     return;
        // }
        
        //if full
        if(rear == size-1){
            System.out.println("Queue is full");
            return;
        }
        rear = rear+1;
        arr[rear] = n;
        return;
       }

       //remove
       public static int remove(){
        if(isEmpty()){
            return -1;
        }
        int first = arr[0];
        //less then rear
        for(int i = 0;i < rear;i++){
            //shifting one forward - people are walking forward as one man has left the queue
            arr[i] = arr[i+1];
        }
        //make the rear = rear -1 or make sure rear point to last ele , so as one man left, rear should decrese
        rear = rear-1;
        return first;
       }

       //peek
       public static int peek(){
        if(isEmpty()){
            return -1;
        }
        return arr[0];
       }
    
    }
    public static void main(String[] args) {
        Queue q = new Queue(5);
        System.out.println(q.isEmpty());
        q.add(4);
        q.add(5);
        q.add(9);
        // System.out.println(q.isEmpty());
        // q.remove();
        // System.out.println(q.peek());
        // q.remove();
        // System.out.println(q.peek());
        // System.out.println(q.size);
        
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}