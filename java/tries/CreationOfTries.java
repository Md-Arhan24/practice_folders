class CreationOfTries {
    static class Tries {
        static class Node {
            Node[] children = new Node[26];// here only we intilzed it, not need it in constrcutor
            boolean eow;// end of word
        }
        public static Node root = new Node();

        public static void insert(String word){
            //make a pointer to traverse
            Node curr = root;

            for(int level = 0;level < word.length();level++){
                //first check in root
                int idx = word.charAt(level)-'a';
                if(curr.children[idx] == null){
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }

            //as curr contain last node of word, so we make it as eow
            curr.eow = true;
        }

        public static boolean search(String word){
            Node curr = root;
            for(int i = 0;i < word.length();i++){
                int idx = word.charAt(i)-'a';
                if(curr.children[idx] == null)return false;
                curr = curr.children[idx];
            }
            if(curr.eow == true)return true;
            return false;
        }
    }

    public static void main(String[] args) {
        Tries t = new Tries();
        String word[] = { "the", "a", "their", "them" };
        for (String w : word) {
            t.insert(w);
        }
        System.out.println(t.search("th"));

    }
}