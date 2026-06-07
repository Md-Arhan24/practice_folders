public class PrintNto1 {
    public static void printnto1(int n){
        if(n <= 0){
            return;
        }
        printnto1(n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        printnto1(5);
    }
}
