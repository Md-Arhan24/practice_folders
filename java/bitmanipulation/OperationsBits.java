public class OperationsBits {
    public static int getIthbit(int n, int i) {
        // make a bit mask
        int bitmask = 1 << i;
        if ((n & bitmask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthbit(int n, int i) {
        // make a bit mask
        int bitmask = 1 << i;
        return n | bitmask;
    }

    public static int clearIthbit(int n, int i) {
        // make a bit mask
        int bitmask = ~(1 << i);// as we do 1<<i we get one at ith position but we want zero so we do negation

        return n & bitmask;
    }

    public static int updateBitmask(int n, int i, int newBit) {
        // very basic
        // if(newBit == 0){
        // return clearIthbit(n, i);
        // }else{
        // return setIthbit(n, i);
        // }

        // without using setbit
        int clear = clearIthbit(n, i);// first clear the bit
        int bitMask = newBit << i;// getting the ith bit to zero or one
        return clear | bitMask;
    }

    public static int clearBit(int n, int i) {
        int bitmask = -1 << i;
        return n & bitmask;
    }

    public static int clearInRange(int n, int i, int j) {

        // to do this first we need bitmask which has allzeros after j and all ones
        // before i
        // so we divide it into two sub problesm , which is a and b when we do a |b we
        // get bitmask
        // now main thing is how to get a nad b
        // we get a which is j after all ones 1111000000000 we can get this by left
        // shift j with -1
        // for b we want 00000000111111 to get this we have a forumla check it in notes
        //  int a = (-1) << j;
        int a = (-1) << (j+1);//  here we take +1 because range is from 1
        int b = (1 << i) - 1;
        int bitmask = a | b;
        return n & bitmask;

    }

    public static void main(String[] args) {

        System.out.println(getIthbit(5, 4));// answer will be 0 as 5 - 00000101 as 4 bit is 0
        System.out.println(getIthbit(5, 2));// answer will be 1 as 5 - 00000101 as 2 bit is 1
        System.out.println(setIthbit(10, 2));// 14
        System.out.println(clearIthbit(10, 1));// 8
        System.out.println(updateBitmask(10, 1, 0));// 8
        System.out.println(clearBit(15, 2));// here we clear last 2 bits
        System.out.println(Math.pow(2, 4));// 2^4
        System.out.println(1 << 4);// this is also same 2^4 = 1*2^4
       System.out.println(clearInRange(10, 2, 4));
    }
}
