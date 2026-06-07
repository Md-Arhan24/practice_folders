public class Static {
    public static void main(String[] args) {
        // Student s = new Student();
       
        // Student s1 = new Student();
        System.out.println(Student.Schoolname);
    }
}
class Student{
    String name;
    int roll;
    static final String Schoolname =  "SVSHS";
    void setName(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }

}