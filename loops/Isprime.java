import java.util.Scanner;
public class Isprime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number:");
        int num = sc.nextInt();
boolean isPrime = true;
if(num <=2 && num > 0){//the loop set false when we hit 2,so to overcome we set this codnition
System.out.println("it is prime");
}else{
for(int i = 2;i<=Math.sqrt(num);i++){//to reduce time complexity we use Math.sqrt() fucntion
	if(num % i == 0){
		isPrime = false;
		}
	}
	if(isPrime){
	System.out.println("is a prime number");
	}
	else{
	System.out.println("is not a prime number");
	}
	}
    }
}
