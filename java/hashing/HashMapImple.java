import java.util.LinkedList;
import java.util.ArrayList;

public class HashMapImple {
    //every operation is less then lambda which is O(1)
    static class HashMap<K, V> {// generics
        private class Node {
            K key;
            V vlaue;

            Node(K key, V value) {
                this.key = key;
                this.vlaue = value;
            }
        }

        private int n;// n all nodes of hashmap
        private int N;// size of the buckets
        private LinkedList<Node> buckets[];// array of ll
        // to over come the belwo error we use

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.n = 0;
            this.buckets = new LinkedList[4];// error : Cannot create a generic array of
                                             // LinkedList<HashMapImple.HashMap<K,V>.Node>
            for (int i = 0; i < 4; i++) {// every time size 4 (?)
                this.buckets[i] = new LinkedList<>();

            }
        }

        private int hashFunction(K key) {
            int hv = key.hashCode();
            // if get negative then we have to conver it to +
            // return Math.abs(hv);//but we want it to be in between 0 - size
            return Math.abs(hv) % N;

        }

        private int nodeIdx(K key, int bucketIdx) {
            int idx = 0;
            LinkedList<Node> ll = buckets[bucketIdx];// access the bucket index ll
            for (Node curr : ll) {
                if (curr.key == key) {
                    return idx;
                }
                idx++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            // store the old buck
            LinkedList<Node> old_bucket[] = buckets;
            buckets = new LinkedList[N * 2];
            N = N * 2;//double the size

            // initlize the new buckets with all empty LL
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // take the values from the old bucket and put it into new bucket
            for (int i = 0; i < old_bucket.length; i++) {
                LinkedList<Node> temp = old_bucket[i];
                // for (Node curr : temp) {//we have to remove the nodes from the LL
                //     put(curr.key, curr.vlaue);
                // }
                for(int j = 0;j < temp.size();j++){
                    Node curr = temp.remove(j);
                    put(curr.key,curr.vlaue);

                }
            }

        }

        public void put(K key, V value) {
            int bucketIdx = hashFunction(key);
            int dataIdx = nodeIdx(key, bucketIdx);

            // if the key is there
            if (dataIdx != -1) {
                Node temp = buckets[bucketIdx].get(dataIdx);
                temp.vlaue = value;
            } else {
                // if it is not exits ,create a new node
                Node temp = new Node(key, value);
                buckets[bucketIdx].add(temp);
                n++;
            }

            // calculate lambd , striclty greater then 2.0
            double lambda = (double) n / N;
            if (lambda > 2) {
                rehash();// rehash - arrange it in corret order
            }
        }

        public boolean containsKey(K key) {
            // get the bucket index
            int bucketIdx = hashFunction(key);
            // get the LL on bucketidx
            LinkedList<Node> ll = buckets[bucketIdx];
            for (Node curr : ll) {
                if (curr.key == key) {
                    return true;
                }
            }
            return false;
        }

        public V get(K key) {
            int bucketIdx = hashFunction(key);
            int dataIdx = nodeIdx(key, bucketIdx);

            // if the key is there
            if (dataIdx != -1) {
                Node temp = buckets[bucketIdx].get(dataIdx);
                return temp.vlaue;
            }
            return null;

        }

        public V remove(K key) {
            int bucketIdx = hashFunction(key);
            int dataIdx = nodeIdx(key, bucketIdx);

            // if the key is there
            if (dataIdx != -1) {
                Node temp = buckets[bucketIdx].remove(dataIdx);
                n--;
                return temp.vlaue;
            }
            return null;

        }
        public ArrayList<K> keySet(){
            ArrayList<K> ans = new ArrayList<>();
            if(isEmpty()){
                return ans;
            }
            for(int i = 0;i < buckets.length;i++){
                LinkedList<Node> temp = buckets[i];
                for(Node curr:temp){
                    ans.add(curr.key);
                }
            }
            return ans;

        }
        public boolean isEmpty(){
            return n ==0;
        }

    }

    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("china", 130);
        hm.put("nepal", 20);
        hm.put("pakistan",30);
    
        //get the keyset
        ArrayList<String> keys = hm.keySet();
        for(String k:keys){
            System.out.println(k +" "+hm.get(k));
        }
        System.out.println("-----------");
        hm.put("IRAN",100);
         ArrayList<String> key = hm.keySet();
        for(String k:key){
            System.out.println(k +" "+hm.get(k));
        }
        System.out.println("------------------");
        hm.remove("nepal");
        hm.put("nepal", 100);
        hm.put("nepal", 101);
         ArrayList<String> ke = hm.keySet();
        for(String k:ke){
            System.out.println(k +" "+hm.get(k));
        }



    }
}