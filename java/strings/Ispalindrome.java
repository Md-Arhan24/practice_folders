import java.util.Scanner;
public class Ispalindrome{
    public static boolean isPlaindrom(String str){
        for(int i = 0;i < str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    
    public static boolean isPalindromeOptimize(int x) {
        int rev_no=0;
        int n=0;
        int org= x;
        char sign= '-';
        while(x!=0){
            n=x%10;
           
            rev_no= rev_no*10+n;
        
            
             x= x/10;
        }

        if(org<0){
                rev_no= rev_no*sign;
            }
            if(org== rev_no)
            {
                return true;
            }else{
                return false;
                }
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string you want to check for palindrome: ");
        String str = sc.nextLine();
        if(isPalindromeOptimize(Integer.valueOf(str))){
            System.out.println("its palindrome");
        }else{
            System.out.println("its not plaindrome");
        }
        System.out.println("last");
        // System.out.println(121*'-');
        // System.out.println('a'-'a');//0
        // System.out.println('a'-0);//ascii value
        // System.out.println(0-'a');//?
        // System.out.println('A'-'a');
        
    }
}