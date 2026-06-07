public class PrintSum {
    public static int getSumofFistn(int n){
        if(n <= 1){
            return 1;
        }
        
       return n + getSumofFistn(n-1);
       
    }
    public static void main(String[] args) {
        System.out.println(getSumofFistn(10));
    }
}
