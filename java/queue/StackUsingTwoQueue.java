import java.util.*;
public class StackUsingTwoQueue {
    static class Stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        //any one of them can be empty
        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void add(int data){
            if(!q1.isEmpty()){
                //q1 has elements - so we have to add it where the elements are present
                q1.add(data);
            }else{

                q2.add(data);
            }
        }

        public static int remove(){
            if(q1.isEmpty() && q2.isEmpty()){
                return -1;
            }
            int ele = -1;//it must be intilized
            if(q1.isEmpty()){
                //q2 has elements
                
                while(!q2.isEmpty()){
                    ele = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(ele);
                }
            }else{
                //q1 has elements

                while(!q1.isEmpty()){
                    ele = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(ele);
                }
            }
            return ele;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            int ele = -1;
            if(q1.isEmpty()){
                //q2 has elements
                while(!q2.isEmpty()){
                    ele = q2.remove();
                    q1.add(ele);
                }
            }else{
                //q1 has elemts
                while(!q1.isEmpty()){
                    ele = q1.remove();
                    q2.add(ele);

                }
            }
        return ele;
        }


    }
    public static void main(String[] args) {
        Stack st = new Stack();
        st.add(1);
        st.add(2);
        st.add(3);
        
        while(!st.isEmpty()){
            System.out.println(st.peek());
            st.remove();
        }
        
    }
}
