package bitmanipulation;
import java.util.Scanner;

import java.util.Scanner;

public class EvenorOdd {
    public static void main(String[] args) {
        System.out.println("Enter the number :");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        if((s&1) == 1){
            System.out.println("its an odd number");
        }else{
            System.out.println("its an even number");
        }
    }
}
