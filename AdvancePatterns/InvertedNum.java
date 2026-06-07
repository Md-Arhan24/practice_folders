public class InvertedNum {
    public static void print_invertedNum(){
        for(int i = 5;i>=1;i--){
            for(int j = 1;j <= i;j++){
                System.out.print(j);
            }
            for(int k = 1;k <=5-i;k++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        print_invertedNum();
    }
}
