public class TilingProblem{
    public static int getWays(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        return getWays(n-1)+getWays(n-2);
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(getWays(n));
    }
}