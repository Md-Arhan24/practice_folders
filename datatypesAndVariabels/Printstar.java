public class Printstar {
    public static void main(String[] args) {
        /*here is the pattern of star try to print this same "***"
         *                                                   "**"
         *                                                   "*"
         */

         //basic idea will be
         System.out.println("***");
         System.out.println("**");
         System.out.println("*");

         //or

         for(int i = 5;i > 0;i--){
            for(int j = i;j > 0;j--){
            System.out.print('*');
         }
         System.out.println();
        }

    }
}
