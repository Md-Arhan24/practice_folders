package bitmanipulation;

public class BitsOperator {
    public static void main(String[] args) {
        System.out.println(~5+1);//-5
        System.out.println(~5);//-6
        System.out.println(~0);//-1
        System.out.println(0b000101);//5
        System.out.println(0b0000101+1);//6 - binary
        System.out.println(00000101);//66 - octal (by default)
        System.out.println(5<<2);//20 - 5 * 2^2
        System.out.println(6 >>1);//3 - 6 / 2 ^ 1
    }
}
