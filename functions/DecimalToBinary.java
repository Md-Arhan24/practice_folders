public class DecimalToBinary {
    public static void decimalToBinary(int n){
	StringBuilder sb = new StringBuilder();
	
	while(n >= 1){
		int reminder = n % 2;
		n = n / 2;
		sb.append(reminder);
		}
		sb.reverse();
		
		System.out.println(sb);
	}
    public static void main(String[] args) {
        decimalToBinary(7);
    }
}

