import java.util.Scanner;
public class Taxcalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("hi,sir please enter your monthly salary : ");
        double num = sc.nextDouble();

        if(num < 500000){
            System.out.println("congratulation ! you have to pay 0% tax");
        }
        else if(num >= 500000 && num >= 100000){
            System.out.println("you have to pay 20% tax from your salary");
            System.out.println("here is the amount you get in your account:");
            double tax_to_be_paid_from_salary = num * (0.2);
            double amount_got = num - tax_to_be_paid_from_salary;
            System.out.println(amount_got);
            System.out.println("tax deducted from your salary :" + tax_to_be_paid_from_salary);
        }
        else{
             System.out.println("you have to pay 30% tax from your salary");
            System.out.println("here is the amount you get in your account:");
            double tax_to_be_paid_from_salary = num * (0.3);
            double amount_got = num - tax_to_be_paid_from_salary;
            System.out.println(amount_got);

            System.out.println("tax deducted from your salary :" + tax_to_be_paid_from_salary);
        }
    }
}
