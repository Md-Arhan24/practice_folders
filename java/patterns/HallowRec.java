class HallowRec{
    public static void main(String[] args) {
        int value = 9;
        for(int i = 0;i < 9;i++){
            for(int k = value;k > 0;k--){
                System.out.print(" ");
            }
            for(int j = 0;j < 9;j++){
                if(i == 8 || i == 0 || j == 0 || j == 8){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
            value--;
        }
    }
}