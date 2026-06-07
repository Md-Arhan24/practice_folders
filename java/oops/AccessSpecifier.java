public class AccessSpecifier {
    public static void main(String[] args) {
        // Test t = new Test();
        // t.a = 9;
        // t.b = 9;
        // t.sum(t.a,t.b);
        // Test1 t1 = new Test1();
        // t1.a = 7;
        // t1.b = 7;
        // t1.sum(t1.a, t1.b);
        Bank b = new Bank("arhan", 7800,9999.999993);
        b.getBalance();
    }
    
}
class Test{
        int a;
        int b;
        void sum(int a,int b){
            System.out.println(a+b);
            return;
        }
    }
class Test1 extends Test{

}
class Bank{
    private String name;
    private int pass;
    private double balance;

    private void setValues(String name,int pass,double balance){
        this.name = name;
        this.pass = pass;
        this.balance = balance;
    }


    Bank(String name,int pass,double balance){
        setValues(name, pass, balance);
    }
    void getBalance(){
        System.out.println("balance for "+this.name +" is" + this.balance);;
    }
}