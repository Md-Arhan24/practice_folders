public class Rhombus {
    public static void print_rhombus(int n){
        for(int i = 1;i <= n;i++){
            //first space - formula (n-i)
            for(int j = 1;j <= (n-i);j++){
                System.out.print(" ");
            }
            for(int l = 1;l <= n;l++){
                System.out.print("*");
            }
        System.out.println();
        }
    }
    public static void main(String[] args) {
        print_rhombus(7);
    }
}
