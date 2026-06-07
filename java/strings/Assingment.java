import java.util.Scanner;
public class Assingment {
    public static void printCountOfLowerCaseVowels(String str){
        int count = 0;
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i)== 'a' || str.charAt(i)== 'e' ||str.charAt(i)== 'i' ||str.charAt(i)== 'o' ||str.charAt(i)== 'u'  ){
                count++;
            }
        }
        System.out.println(count);
    }
    public static void checkAnagaram(String s1,String s2){
        if(s1.length() != s2.length()){
            System.out.println("they are not anagaram");
            return;
        }
        int count [] = new int [26];
        for(char c : s1.toCharArray()){
            count[c - 'a']++;
        }
        for(char c : s2.toCharArray()){
            count[c - 'a']--;
        }
        for(int i = 0;i < count.length;i++){
            if(count[i] != 0){
                System.out.println("they are not anagaram");
                return;
            }
        }
        System.out.println("yes they are anagaram");

    }
    public static void main(String[] args) {
        System.out.println("Enter the string");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printCountOfLowerCaseVowels(str);
        System.out.println("enter two string to check they are anagaram or not:");
        String first = sc.next();
        String last = sc.next();
        checkAnagaram(first,last);
    }
}
