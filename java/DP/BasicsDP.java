public class BasicsDP{
    public static void main(String[] args) {
        int n = 6;
        int memo [] = new int [n+1];//created a memory
       System.out.println(printFib(n,memo));//every time iniltized to zero by default
    }
    public static int printFib(int n,int memo []){
        if(n == 0 || n == 1){
            return n;
        }
        if(memo[n] != 0){//it means the value of fib(n) is know to use, so return that
            return memo[n];
        }
      memo[n] =  printFib(n-2,memo)+printFib(n-1,memo);
      return memo[n];
    }
}