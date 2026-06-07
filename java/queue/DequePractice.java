import java.util.*;
import java.util.LinkedList;
public class DequePractice{
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addLast(2);
        dq.addLast(3);
        dq.addLast(9);
        dq.addLast(10);
        System.out.println(dq);

        // System.out.println("acting as queue");
        // while(!dq.isEmpty()){
        //     System.out.println(dq.removeFirst());
        // }

         System.out.println("acting as stack");
        while(!dq.isEmpty()){
            System.out.println(dq.removeLast());
        }
    }
}