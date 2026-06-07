import java.util.Scanner;

public class DecimalToBinary {
    public static String decimalTobinary(int a) {

        if (a < 2) {
            return String.valueOf(a);
        }

        return decimalTobinary(a / 2) + (a % 2);

    }

    public static int bianryToDecimal(int a) {
        String bin = String.valueOf(a);
        int ans = 0;
        for (int i = 0; i < bin.length(); i++) {

            // ans += Integer.valueOf(String.valueOf(bin.charAt(i))) * (int) Math.pow(2, bin.length() - 1 - i);
            ans+= (bin.charAt(i) - '0') * (int)Math.pow(2,bin.length()-i-1);
            // System.out.println((bin.charAt(i) - '0'));
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(decimalTobinary(a));
        System.out.println(bianryToDecimal(Integer.valueOf(decimalTobinary(a))));
    }
}
