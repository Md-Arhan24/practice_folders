public class WaysCanBeSingleAndPair {
    public static int getWays(int n){
        if(n == 1|| n == 2){
            return n;
        }

        //see here that n-1 is number of single we can get and we have to add it with number of pairs we can formed
        //so we can get this by choosing n-1 person with n-2 persons. so we multiplyed is(permutaitons.)
        return getWays(n-1) + (n-1)*getWays(n-2);
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(getWays(n));
    }
}
