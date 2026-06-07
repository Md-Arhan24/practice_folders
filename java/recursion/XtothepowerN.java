public class XtothepowerN {
    public static int getXtoN(int x,int n){
        if(n == 1){
            return x;
        }
        return x * getXtoN(x, n-1);
    }
    public static int getXtoNOptimized(int x,int n){
        //base case
        if(n == 1){
            return x;
        }
        
        //n is even
        int halfValue = getXtoNOptimized(x, n/2);
        if((n&1) == 0){
           return halfValue*halfValue;
        }else{
           return  2 * halfValue*halfValue;
        }
    }
    public static void main(String[] args) {
        System.out.println(getXtoNOptimized(2,5));//2^10
    }
}
