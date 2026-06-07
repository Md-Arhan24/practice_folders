//this problem came in google and amazon that count number of 
//set bits of a given number

//so the appraoch we follow is see lsb if 1 count++ 

public class CountSetBit {

    public static int CountSetBits(int n){
        //run loop until there is no one which is zero
        int count = 0;
        while(n>0){
            //to check lsb just do and
            if((n&1) == 1){
                count++;
            }
            n = n>>1;//n right shift by 1
        }
        return count;
        
    }
    public static int optimizeApproach(int n){
        int count = 0;
        while(n > 0){
            count++;
            //- Each iteration removes one set bit, so the loop runs exactly as many times as there are set bits.

            n = (n & (n-1));//this we have used to check the power of 2
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(CountSetBits(15));//4
    }

    
}
