public class ZeroOnepattern {
    public static void main(String[] args) {
        boolean num = true;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num ? 1 : 0);//brilliant idea by claude
                num = !num;
            }
            System.out.println();
        }
    }

}