public class Factorial {
    public static int factorial(int n){
        int sum = 1;
        while(n >= 1){
             sum *= n;
            n--;

        }
        return sum;
    }
    public static void main(String[] args) {
        int fact = factorial(5);
        System.out.println(fact);
    }
}