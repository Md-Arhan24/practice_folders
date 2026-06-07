import java.util.Comparator;
import java.util.PriorityQueue;
class PQforobjects{
    static class Student implements Comparable<Student>{
        int marks;
        String name;

    public Student(int marks,String name){
        this.marks = marks;
        this.name = name;

     }

     @Override
     public int compareTo(Student s2){
        // return this.marks - s2.marks; ascending order
        return s2.marks - this.marks;//desecnding order
     }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
       
        pq.add(new Student(99, "A"));
        pq.add(new Student(95, "d"));
        pq.add(new Student(93, "e"));
        pq.add(new Student(94, "d"));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name +" -> "+pq.peek().marks);
            pq.remove();
        }
        

    }
}