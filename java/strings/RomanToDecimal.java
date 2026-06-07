import java.util.*;

public class RomanToDecimal {

    public static int getDecimal(String s,Map<String,Integer>roman) {
        int total_count = 0;
        
        int a = 0, b = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            a = roman.get(String.valueOf(s.charAt(i)));
            b = roman.get(String.valueOf(s.charAt(i + 1)));
            if (a >= b) {
                total_count += a;

            } else {
                total_count += (b - a);
                i++;
                if (i >= s.length() - 1) {
                    return total_count;
                }
            }

        }

        return total_count + b;

    }

    public static int getDecimalOptimize(String s,Map<String,Integer> roman){
        int i = 0,total_count =0;
        while(i < s.length()){
            int current = roman.get(String.valueOf(s.charAt(i)));
            int next = (i+1 < s.length() ? roman.get(String.valueOf(s.charAt(i+1))) : 0);//here we dont need , we can iterate overall char

            if(current < next){
                total_count-=current;
            }else{
                total_count+=current;
            }
            i++;
        }
        return total_count;
    }
    
    
        
    public int romanToIntBest(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    if (i < s.length() - 1) {
                        char next = s.charAt(i + 1);
                        if (next == 'V') {
                            num += 3;
                            i++;
                        } else if (next == 'X') {
                            num += 8;
                            i++;
                        }
                    }
                    num += 1;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    if (i < s.length() - 1) {
                        char next = s.charAt(i + 1);
                        if (next == 'L') {
                            num += 30;
                            i++;
                        } else if (next == 'C') {
                            num += 80;
                            i++;
                        }
                    }
                    num += 10;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    if (i < s.length() - 1) {
                        char next = s.charAt(i + 1);
                        if (next == 'D') {
                            num += 300;
                            i++;
                        } else if (next == 'M') {
                            num += 800;
                            i++;
                        }
                    }
                    num += 100;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
                default:
                    num += 0;
                    break;
            }
        }
        return num;
    }

    
    public static void main(String[] args) {
        Map<String, Integer> roman = new HashMap<>();
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);
        String s = "LVIII";
        System.out.println(getDecimalOptimize(s,roman));

    }
}