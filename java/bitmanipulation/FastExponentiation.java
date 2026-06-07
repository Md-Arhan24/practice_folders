public class FastExponentiation {
    public static double calculateExpo(double n,int m){
        if(m < 0){
            return 1/calculateExpo(n,Math.abs(m));//it wont hanlde if negatice is more than int range
        }
        double a = n, ans = 1;
        while(m > 0){
            //checking lsb if 1 then a = ans*a
            if((m&1) == 1){
                ans = ans*a;
            }
            a = a*a;
            m = m>>1;

        }
        
        return ans;
    }

    //best approch using long - leetcode best
    public static double calculateExpoBest(double n,int m){
        long M = m;//to hanlde large inputs
        if(M < 0){
            n = 1/n;
            M = -M;
        }
        double a = n,ans = 1;
        while(M > 0){
            if((M&1) == 1){
                ans = ans*a;
            }
            a = a*a;
            M = M>>1;
        }
        return ans;
    }
   
   
    public static void main(String[] args) {
        System.out.printf("%.5f\n",calculateExpo(2.00000,-2));
        System.out.printf("%.5f",calculateExpoBest(2.00000,-2147483648));
    }
}
