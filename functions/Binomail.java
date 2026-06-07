public class Binomail {
    public static int factorial(int n){
        int sum = 1;
        while(n >= 1){
             sum *= n;
            n--;

        }
        return sum;
    }
    public static void main(String[] args) {
        //formuls for binomail is n!/r! * (n-r)!
        //lets call factorial for n,r and n - r;
        int binomil = factorial(5) / (factorial(2) * factorial(5-2));
       
        System.out.println(binomil);
    }
}
