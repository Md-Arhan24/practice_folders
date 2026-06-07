package hashing;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("A",100);
        hm.put("B",200);
        // System.out.println(hm.get("c"));//null
        // System.out.println(hm.containsKey("a"));
        // System.out.println(hm.containsValue(200));
        // System.out.println(hm.remove("a"));
        // System.out.println(hm);
        // System.out.println(hm.remove("A"));
        // System.out.println(hm.size());
        for(String key:hm.keySet()){
            System.out.println(key+" "+hm.get(key));
        }
    }
}
