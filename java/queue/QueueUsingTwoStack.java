import java.util.*;
public class QueueUsingTwoStack {
    static class Queue{
        static  Stack<Integer> st1 = new Stack<>();
        static Stack<Integer> st2 = new Stack<>();

        public static boolean isEmpty(){
            return st1.isEmpty();
        }

        public static void add(int data){
            if(st1.isEmpty()){
                st1.add(data);
                return;
            }
            //make the stack empty
            while(!st1.isEmpty()){
                st2.add(st1.pop());
            }
            st1.add(data);
            while(!st2.isEmpty()){
                st1.add(st2.pop());
            }

        }
        public static int pop(){
            if(st1.isEmpty()){
                return -1;
            }
            return st1.pop();
        }
        public static int peek(){
            if(st1.isEmpty()){
                return -1;
            }
            return st1.peek();
        }
    }
   
    static class Queue2{
        static Stack<Integer> st1 = new Stack<>();
        static Stack<Integer> st2 = new Stack<>();

        public static boolean isEmpty(){
            return st1.isEmpty();
        }

        //add
        public static void add(int data){
            st1.add(data);
        }

        //remove
        public static int pop(){
            // make the st1 empty
            if(st1.isEmpty()){
                return -1;
            }

            while(!st1.isEmpty()){
                st2.add(st1.pop());
            }
            int data = st2.pop();
            //it there is only one ele.
            if(st2.isEmpty()){
                return data;
            }
            while(!st2.isEmpty()){
                st1.add(st2.pop());
            }
            return data;
        }

        //peek
        public static int peek(){
            // make the st1 empty
            if(st1.isEmpty()){
                return -1;
            }

            while(!st1.isEmpty()){
                st2.add(st1.pop());
            }
            int data = st2.peek();
            while(!st2.isEmpty()){
                st1.add(st2.pop());
            }
            return data;
        }
    }
   
    public static void main(String[] args) {
       Queue2 q = new Queue2();
       q.add(1);
       q.add(2);
       q.add(3);
       while(!q.isEmpty()){
        System.out.println(q.pop());
       }
       
        
    }
}
