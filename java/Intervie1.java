import java.util.*;
import java.util.LinkedList;
public class Intervie1{
    //stack using two queus
    //the operation in stack are
    //push
    //pop
    //peek
    public static class Stack{//lifo

       static  Queue<Integer> q1 = new LinkedList<>();
       static Queue<Integer> q2 = new LinkedList<>();

        //isEmpty
        public static boolean isEmpty(){
            return q1.isEmpty();
        }

        //push
        public static void push(int data){
            if(isEmpty()){
                q1.add(data);
                return;
            }
            //if the data is already eixts then we have to empty the q1 and add the elemet and then again fill the q1
            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }
            q1.add(data);
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }

        }

        //pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            //if it is not empty   1 2 3
            int data = -1;
            while(!q1.isEmpty()){
                 data = q1.remove();
                q2.add(data);
            }
            int size = q2.size();
            while(size-- > 1){//one becuse we dont want last element
                q1.add(q2.remove());
            }
            return data;
        }

        //peek - it return the top most element
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
             //if it is not empty   1 2 3
            //if it is not empty   1 2 3
            int data = -1;
            while(!q1.isEmpty()){
                 data = q1.remove();
                q2.add(data);
            }
            int size = q2.size();
            while(size-- > 0){//one becuse we dont want last element
                q1.add(q2.remove());
            }
            return data;
        }
    }
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(0);
        st.push(1);
        st.push(2);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.peek());

        

        
    }
}

//mistakes
/* mistakes  
in is empty she check for both, where as i have check for one only. q1.


*/