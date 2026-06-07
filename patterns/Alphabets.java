public class Alphabets {
    public static void main(String[] args) {
        // char a = 'B';

        // System.out.println((char)66);

        int num = 65;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((char) num + " ");
                num++;
            }
            System.out.println();
        }
    }

}