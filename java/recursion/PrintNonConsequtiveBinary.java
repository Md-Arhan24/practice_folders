public class PrintNonConsequtiveBinary {
    public static void printNonConsequtiveBinaryStrings(int n, int lastDigit, String str) {
        if(n == 0){
            System.out.println(str);
            return;
        }
      
        //work
        printNonConsequtiveBinaryStrings(n-1, 0, str+0);//zero sit //first i worte printNonConsequtiveBinaryStrings(n-1, 0, str+=0);
        if(lastDigit == 0){                                                     
            printNonConsequtiveBinaryStrings(n-1, 1, str+1);//one sit  // printNonConsequtiveBinaryStrings(n-1, 1, str+=1)
        }

    }
   public static void printNonConsequtiveBinaryStringsZeros(int n,int lastDigit,String str){
    if(n == 0){
        System.out.println(str);
        return;
    }
    printNonConsequtiveBinaryStringsZeros(n-1, 1, str+1);
     if(lastDigit == 1){
        //if one then we can print zero as well as one
        printNonConsequtiveBinaryStringsZeros(n-1, 0, str+0);
     }
   }
    public static void main(String[] args) {
        int n = 3;
        // printNonConsequtiveBinaryStrings(n, 0, "");
        // output
        /*
         * 000
         * 001
         * 010
         * 100
         * 101
         */

        //no zero shoud be consiqutive
         printNonConsequtiveBinaryStringsZeros(n, 1, "");
         //output
         /*
          * 010
            011
            101
            110
            111
    
          */
    }
}
