import java.util.*;
import java.util.LinkedList;
public class QueueUsingDeque {
    static class Queue{
       static Deque<Integer> dq = new LinkedList<>();

        public static boolean isEmpty(){
            return dq.isEmpty();
        }

        public static void add(int data){
            dq.addLast(data);
        }

        public static int remove(){
           return dq.removeFirst();
        }

        public static int peek(){
            return dq.getFirst();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(3);
        q.add(5);
        q.add(7);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
