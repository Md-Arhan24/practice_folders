public class HallowRectangle {
    public static void print_hallow(){
        for(int row = 1;row <= 4;row++){
            for(int col = 1;col <= 10;col++){
                if(row == 1|| row == 4|| col == 1|| col == 10){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
        System.out.println();
        }
    }
    public static void main(String[] args) {
        print_hallow();
    }
}