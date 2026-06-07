class ClimbingStairs{
    public static void main(String [] args){
        int n = 5;//steps 1 2 3
        System.out.println(getStairs(n));
    }
    public static int getStairs(int n){
        if(n < 0)return 0;
        if(n == 0)return 1;
        return getStairs(n-1)+getStairs(n-2)+getStairs(n-3);
    }
}