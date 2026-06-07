import java.util.Scanner;
public class Print_patternSqr{
    public static void main(String[] args) {
        //print below pattern
// *****
// *****
// *****

// for(int i = 0;i < 3;i++){
// 	for(int j = 0;j <=4;j++){
// 		System.out.print("*");
// 		}
// 		System.out.println();
// 	}

// -----------------------------------------
Scanner sc = new Scanner(System.in);
// System.out.println("enter the number :");
// String s = sc.nextLine();
//print reverse of a number
// a = 100384038;
// output : 830483001


// for(int i = s.length() - 1;i >= 0;i--){
// 	System.out.print(s.charAt(i));
// 	}
//or
//  String reversed_str = new StringBuilder(s).reverse().toString();
//  System.out.println(reversed_str);
// or
//based on this logic : to get last digit use % and to remove last digit / by 10
        System.out.println("enter the number: ");
        int a = sc.nextInt();
        int length = (int) Math.log10(a) + 1;
        // for(int i = 0; i < length;i++){
        //     int reverse = a % 10;
            
        //     System.out.print(reverse);
        //     a = a/10;
        // }
        while(a > 0){
        int reverse = a%10;
        System.out.print(reverse);
        a/=10;
        }

    }
}