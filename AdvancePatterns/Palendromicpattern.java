public class Palendromicpattern {
    public static void print_palendromic(int n) {
        for (int i = 1; i <= n; i++) {
            // space
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // print n to 1
            for (int j = i; j >= 1; j--) {
                System.out.print(j);

            }
            // print 2 to n
            for (int k = 2; k <= i; k++) {

                System.out.print(k);

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print_palendromic(5);
    }
}
