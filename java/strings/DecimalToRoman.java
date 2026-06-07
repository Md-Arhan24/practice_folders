import java.util.*;
public class DecimalToRoman {
    public static String decimalToRoman(int n,Map<Integer,String> table){
        int i = 0;String ans = "";
      
        while(n >0){
            System.out.println(n);
            for(Map.Entry<Integer,String> e:table.entrySet()){
            if(e.getKey() < n){
                ans+=e.getValue();
                
            }
            
            n-=e.getKey();

        }

        }
        
        return ans;
    }
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> table = new LinkedHashMap<>();
        table.put(1000,"M");
        table.put(900,"CM");
        table.put(500,"D");
        table.put(400,"CD");
        table.put(100,"C");
        table.put(50,"L");
        table.put(40,"XL");
        table.put(10,"X");
        table.put(9,"IX");
        table.put(5, "V");
        table.put(4, "IV");
        table.put(1, "I");

        System.out.println(decimalToRoman(3,table));

    }
}
