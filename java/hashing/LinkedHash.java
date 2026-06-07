import java.util.LinkedHashMap;
import java.util.TreeMap;

public class LinkedHash {
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        TreeMap<String,Integer> hm = new TreeMap<>();
        hm.put("India",100);
        hm.put("China",130);
        hm.put("Iran",80);

       for(String key : hm.keySet()){
        System.out.println(key+" "+hm.get(key));
       }
    }
}
