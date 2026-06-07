public class CallByValue{
    public static void print_sum(int a ,int b){
	a = b;
	b = a;
	
	System.out.println(a + " " + b);
	}
    public static void main(String args[]){
        print_sum(5,6);
    }
}