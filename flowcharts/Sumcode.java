import java.util.Scanner;
public class Sumcode{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter the number a : ");
    int a = sc.nextInt();
      System.out.println("enter the number b : ");
    int b = sc.nextInt();  
    int sum = a+b;
    String s = "the sum of num a :" + a + "and num b :" + b + "is :" + sum;
    System.out.println(s);
 }
}
