import java.util.*;
public class KthLargestOddRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int R = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(getKthOddinRange(L,R,K));

    }
    public static int getKthOddinRange(int l,int r, int k){
        if(k <= 0){
            return 0;
        }
        if(r%2 != 0){
            //r is odd
            double cost  = Math.ceil((r-l+1)/2);//formula is from range a to b incluseive is b-a+1
            if(k > cost){
                return 0;
            }
            return (r-2*k+2);
        }else{
             double cost  = Math.floor((r-l+1)/2);//formula is from range a to b incluseive is b-a+1
            if(k > cost){
                return 0;
            }
            return (r-2*k+1);
        }
    }
}
//how does the formula came (r-2*k+1)?
//why we are doing floor for even or ceil for odd here?
