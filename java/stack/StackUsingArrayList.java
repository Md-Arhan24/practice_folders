import java.util.ArrayList;
public class StackUsingArrayList {
    public static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();

        //isEmpty function
        public static boolean isEmpty(){
            return list.size() == 0;
        }

        //push
        public static void push(int data){
            list.add(data);
        }

        //pop
        public static int pop(){
            //edge case
            if(isEmpty()){
                return -1;
            }
            int data = list.get(list.size()-1); //O(1) because it use some internal formula
            list.remove(list.size()-1);
            return data;
        }

        //peek
        public static int peek(){
            //edge case
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}