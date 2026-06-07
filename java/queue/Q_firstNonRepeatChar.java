import java.util.*;
public class Q_firstNonRepeatChar {
    public static String getFirstNonRepeat(String str){
        if(str.length() == 1){
            return str;
        }
        StringBuilder ans = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        int freq [] = new int [26];
        for(char c : str.toCharArray()){
            q.add(c);
            freq[c-'a']++;

            // while(!q.isEmpty()){
            //     if(freq[q.peek()-'a'] > 1){
            //         q.remove();
            //     }else{
            //         break;
            //     }
            // }
            //or
            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }
           if(q.isEmpty()){
            ans.append(-1);
           }else{
            ans.append(q.peek());
           }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        System.out.println(getFirstNonRepeat(str));
    }
}
