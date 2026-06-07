import java.util.Comparator;
import java.util.PriorityQueue;
public class Pq {
    
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(99);
        pq.add(0);
        pq.add(-8);
        pq.add(-99);//-----------> add O(log n)

        while(!pq.isEmpty()){
            System.out.println(pq.peek());//--------> peek O(1)
            pq.remove();//---------> remove O(log n)
        }
    }
}
