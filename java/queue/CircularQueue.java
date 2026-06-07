public class CircularQueue {
   static class CircularQ{
        static int arr[];
        static int size;
        static int rear;
        static int front;
        
        CircularQ(int size){
            arr = new int[size];
            this.size = size;
            rear = -1;
            front = -1;
        }

        //is empty
        public static boolean isEmpty(){
            return (rear == -1 && front == -1);
        }

        //is full
        public static boolean isFull(){
            return (rear+1)%size == front;
        }

        //add
        public static void add(int data){
            if(isFull()){
                System.out.println("the queue is full");
                return;
            }

            //adding first ele
            if(front == -1){
                front = 0;
                // here we dont need to add the data as it added by rear
                // arr[front] = data;
            }
                rear = (rear + 1)%size;
                arr[rear] = data;
        }

        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            
            int result = arr[front];
           
            //last ele is deleted then make rear and front to -1
            if(rear == front){
                rear = front = -1;
            }else{
                 front = (front+1)%size;
            }
            return result;

        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("list is empty");
                return -1;
            }
            return arr[front];
        }


    }
    public static void main(String[] args) {
        CircularQ q = new CircularQ(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(10);
        q.add(5);
        q.remove();
        q.add(100);
        q.remove();
        q.add(1000);
    

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
        
    }
}
