public class TriangleBinary {
    public static void main(String[] args) {
        // print the belwo patter
        /*
         * 1
         * 1 0 1
         * 1 0 0 0 1
         * 1 0 0 0 0 0 1
         * 1 0 0 0 0 0 0 0 1 //every times 0 increase my 2
         */
        String s = "1 ", l ="", k ="";
        int m = 0;
        
        for(int i = 0;i < 5;i++){
            
            //j as 1 because we dont need l at first
            for(int j = 1;j < m;j++){
                l+="0 ";

            }
            System.out.println(s+l+k);
            k= "1";
            l="";
            m+=2;
        }
    }
}
