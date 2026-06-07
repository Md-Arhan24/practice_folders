public class TypePromotion {
    public static void main(String[] args) {
        short s = 512;
        byte b = 4;
        char c = 'a';
        int i = 10000;
        float f = 3.14f;
        double d = 99.9954;
        
        double result = (f * b) + (i % c) - (d * s);
        System.err.println(result);

        int $ = 5;
        System.out.println($);
    }
}
