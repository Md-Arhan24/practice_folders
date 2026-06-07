public class ModularExpone {
    public static long performModularExpo(long x,long p,long mod){
        //at every step we have to calculate mod
        //so first for base
        long a = x%mod;long ans = 1;
        while(p > 0){
            if((p&1) == 1){
                ans = (ans * a)%mod;
            }
            a = (a*a)%mod;
            p = p>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        long base = 2;
        long pow = 100000;//one lakh
        System.out.println(performModularExpo(base,pow,10));//6
    }
}
