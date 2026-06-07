public class InvertedTri {
    public static void print_invertedTri(int totalrows,int totalcol){
	for(int row = 1;row <= totalrows; row++){//no of rows
		for(int space = 1; space <= totalrows - row;space++){
				System.out.print(" ");
				}
		for(int star = 1;star <= row;star++){
			System.out.print("*");
			}
			System.out.println();
		}
    }
    public static void main(String[] args) {
       print_invertedTri(5,5);
    }
}
