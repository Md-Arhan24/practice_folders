public class Assingment{
    public static void main(String[] args) {
        //3+3i where i is underroot -1
        Complex c1 = new Complex(3, 3);
        //5 +2i
        Complex c2 = new Complex(5, 2);
       Complex sum =  c1.add(c2);
       Complex sub = c1.sub(c2);
       Complex product = c1.product(c2);
       System.out.println(sum.real +" "+sum.imaginary);//8 5
       System.out.println(sub.real +" "+sub.imaginary);//-2 1
       System.out.println(product.real+" "+product.imaginary);//15 6

        
    }
}
class Complex{
    int real;
    int imaginary;
    //consturtor
    Complex(int r,int img){
        this.real = r;
        this.imaginary = img;
    }

    Complex add(Complex c){
        return new Complex(this.real+c.real , this.imaginary+c.imaginary);
    }
     Complex sub(Complex c){
        return new Complex(this.real-c.real , this.imaginary-c.imaginary);
    }
     Complex product(Complex c){
        return new Complex(this.real*c.real , this.imaginary*c.imaginary);
    }

    //more then one sum
    Complex moreSum(Complex [] ar){
        int r = 0,i = 0;
        for(Complex c:ar){
            r+=c.real;
            i+=c.imaginary;
        }
        return new Complex(r, i);
    }

}