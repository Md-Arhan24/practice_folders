public class CopyConstructor{
    public static void main(String[] args) {
        
        // Test1 te = new Test1("sunil", 80, 10.0f);//float must end with f
        // Test1copy tc = new Test1copy(te);
        // tc.printInfo();
        Test t = new Test("arhan",19);
        t.display();
        t.arr[0] = 99;
        t.arr[1] = 98;
        t.arr[2] = 32;

        Test copy_t = new Test(t);//as values were copied so we have to get arhan but it will give gunj
        t.e.address = "gunj";
        t.arr[2] = 99;
        copy_t.array();//99 98 99
        
        
    }
}
class Test{
    String name;
    int age;
    Addres e;
    int arr[];
    class Addres{
        String address;
        Addres(String a){
            this.address = a;
        }
    }
    Test(String name,int age){
        this.name = name;
        this.age = age;
        e = new Addres(name);
        arr = new int[3];
    }
    Test(Test t){
        this.age = t.age;
        this.name = t.name;
        e = new Addres(t.name);
         arr = t.arr;//passed as reference
    }
    void display(){
        System.out.println("name is"+name+"age is "+age+""+e.address);
    }
    void array(){
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
class Test1{
    String name;
    int age;
    float grades;
    Test1(String n,int age,float grades){
        this.name = n;
        this.age = age;
        this.grades = grades;
    }
    void printInfo(){
        System.out.println("name is"+name+"and age is "+age+" grades are"+grades);
    }
}
class Test1copy extends Test1{
    //all properties are inhertied , i avoided again intilizing
    Test1copy(Test1 t){
        super(t.name,t.age,t.grades);
        this.name = t.name;
        this.age = t.age;
        this.grades = t.grades;
    }
}