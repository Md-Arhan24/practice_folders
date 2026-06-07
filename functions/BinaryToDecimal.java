public class BinaryToDecimal {
    public static int binaryToDecimal(int bin){
	//interation thorugh int
	int i = 0;
	int sum = 0;
	while(bin > 0){//dont keep bin >= 0;cause infinte loop
	int last_digit = bin % 10;
	int power = (int) Math.pow(2, i);//math.pow returns double we forcefully converts it to int
	i++;
	int result = last_digit * power;
	 sum+= result;
	bin = bin / 10;
	}
	return sum;
}
    public static void main(String[] args) {
       int a =  binaryToDecimal(100111);
       System.out.println(a);
    }
}
