public class PrintFib {
    public static int getFib(int n){
        if(n == 1){
            return 1;
        }
        if(n <= 0){
            return 0;
        }

        return getFib(n-1)+getFib(n-2);
    }
    public static void main(String[] args) {
        System.out.println(getFib(7));
    }
}
