import java.util.Scanner;
public class Ifprime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number : ");
        int num = sc.nextInt();
        int div = 2;
        while(true){
        if(div < num){
            if(num%div == 0){
               System.out.println("its not a prime number");
                break;
            }
            else{
                div = div + 1;
            }
        }else{
            System.out.println("its a prime number");
            break;
        }
            
            
          
        }
        
    }
}
