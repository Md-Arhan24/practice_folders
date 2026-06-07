public class PrintAllTriplets{
    public static void printTriplets(int n,int i,String str){
        if(n == 0){
            System.out.println(str);
            return;
        }
        if(i == 1){
            printTriplets(n-1, 1, str+1);
            printTriplets(n-1, 0, str+0);
        }
    }
    public static void main(String[] args) {
        int n = 3;
        printTriplets(n,1,"");
    }
}