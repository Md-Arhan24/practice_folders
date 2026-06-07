import java.util.Scanner;
public class IsPrime {
    public static void printAllPrimes(int n) {
        if (n == 2) {
            System.out.println(2);
            return;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j * j <= n; j++) {
                if (i % j == 0) {
                    break;
                }
                System.out.println(i);
                break;

            }

        }
        return;
    }
    public static boolean isPrime(int n){
        if(n >= 2 && n == 2 ){
            return true;
        }

        for(int i = 2;i*i <= n;i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // printAllPrimes(20);
        //another way is
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the range for print primes:");
        int a = sc.nextInt();
        for(int i = 2;i <= a;i++){
            if(isPrime(i)){
                System.out.println(i);

            }
        }

    }
}
