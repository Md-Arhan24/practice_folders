/*you have given an array and you have to find its all occurence
 * example : [1,2,3333,4,2,4,4,4,3,2,1] k = 1 for ele 1 the index are 0,10
 * lets just print them
 */
//appraoch find for first , print i them call for i+1

import java.util.HashMap;

public class Assingment{
    public static void printIndex(int arr[],int k,int i){
        if(i == arr.length){
            return;
        }
        if(arr[i] == k){
            System.out.println(i);
        }
        printIndex(arr, k, i+1);
    }

    //convert the number to a string
    public static void NumtoStr(HashMap<Character,String> hs,String digit,int i){
        if(i == digit.length()){
            return ;
        }
        System.out.print(hs.get(digit.charAt(i))+" ");

        NumtoStr(hs, digit, i+1);
    }

    //another way
    static String array [] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void numtostr(int number){//no need to convert
        if(number == 0){//at last there will never be zero in question its given
            return;
        }
        int i = number%10;
        // System.out.print(array[i]+" ");//printin reverse
        

    numtostr( number / 10);
    System.out.print(array[i]+" ");

    }
   
   
    //3.write a recursion program to find the length of the given string
    public static int findLength(String str){
        if(str.equals("")){
            return 0;
        }

        return findLength(str.substring(1))+1; //printed stack levels

    }
   
    public static int calStartAndEnd(String str,int i,int j,int count){
        if(i == str.length()){
            return count;
        }
        if(j == str.length()){
           return calStartAndEnd(str.substring(i, j), i+1, i+1,count);
            
        }

      if(str.startsWith(String.valueOf(str.charAt(0))) && str.endsWith(String.valueOf(str.charAt(str.length()-1)))){
        count+=1;
        System.out.println(str.charAt(0) + " "+ str.charAt(str.length()-1));
      }
       return calStartAndEnd(str.substring(i, j), i, j+1,count);
    }
   

    //given a string return the count of substrings who first letter and last letter are same.
    public static int CountSub(String str,int i,int j,int size){
        if(size == 1){
            //only one character
            return 1;//one will always valid
        }
        if(size <= 0){
            return 0;
        }

        //first go in depth in recursive call
                    //from 1st index to last     //for 0th index to last sencond    //all middle elemets
        int res = CountSub(str, i+1, j, size-1) + CountSub(str, i, j-1, size-1) - CountSub(str, i+1, j-1, size-2);

        //check i and j
        if(str.charAt(i) == str.charAt(j)){
            res++;
        }
            return res;
    }

    //5. tower of hinoi , here we have given three towers source,destination and helper
    //we have to print step to make which help to move all rings
    //conditions
    //at each time we can only tranfer one disk
    //no big disk will be placed on small one
    public static void TowerOfHinoi(int n,String src,String helper,String des){
        //base case
        if(n == 1){
            System.out.println("move " + n + "disl from "+ src +" "+ des);
            return;
        }


        //first transfer n-1 disk to helper by taking help of des
        TowerOfHinoi(n-1, src, des, helper);
        //then trandfer i mean print n-1 to destination
        System.out.println("move " + n + " disk from "+ src +" "+ des);

        //calculating or transfer n-1 disk to from helper to destin use sor as helper
        TowerOfHinoi(n-1, helper, src, des);
    }
    public static void main(String[] args) {
        int arr [] = {3,2,4,5,6,2,7,2,2};
        // printIndex(arr,2,0);
        HashMap<Character,String> hs  = new HashMap<>();
        hs.put('0',"zero");
        hs.put('1',"one");
         hs.put('2',"two");
        hs.put('3',"three");
         hs.put('4',"four");
        hs.put('5',"five");
         hs.put('6',"six");
        hs.put('7',"seven");
        hs.put('8', "eight");
        hs.put('9', "nine");
        // NumtoStr(hs, "1947", 0);
        // numtostr(2019);
        // System.out.println(findLength("arhan"));
        String str = "a";
    //   System.out.println(CountSub(str, 0, str.length()-1,str.length()));
      TowerOfHinoi(3, "S", "H", "D");
    }
}