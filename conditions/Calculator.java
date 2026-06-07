import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of a:");
        int a = sc.nextInt();
        System.out.println("enter the value of b:");
        int b = sc.nextInt();
        System.out.println("enter the operation(+,-,*,/,%)");
        String operation = sc.next();

        switch (operation) {
            case "+":
                System.out.println("addition of and and b is :" + (a+b));
                break;
            case "-":
                System.out.println("addition of and and b is :" + (a-b));
                break;
            case "*":
                System.out.println("addition of and and b is :" + (a*b));
                break;
            case "/":
                System.out.println("addition of and and b is :" + (a/b));
                break;
            case "%":
                System.out.println("addition of and and b is :" + (a%b));
                break;
            default:
                System.out.println("please enter valid input");
        }
    }
}
