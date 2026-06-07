package strings;

public class PrefixAndSuffixLength {
    public static void main(String[] args) {
            
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        
        String str = "aaa".toLowerCase();
        //code
        String prefix[] = new String[str.length()-1];
        String suffix[] = new String[str.length()-1];

        //loop for prefix
        for(int i = 0;i < str.length()-1;i++){
            
            for(int j = 0; j <= i;j++){
                prefix[j] = str.substring(0,j+1);
            }
        }
        int length = str.length();
        for(int i = 0;i < length-1;i++){
            int inx = 1;
            for(int j = length-1; j >= (length-1-i);j--){
                suffix[(length-1)-j] = str.substring(length-inx,length);
                inx++;
            }
        }
        for(int i = 0;i < prefix.length;i++){
            System.out.print(prefix[i] + " ");
        }
        System.out.println();
         for(int i = 0;i < suffix.length;i++){
            System.out.print(suffix[i] + " ");
        }
        System.out.println();

        System.out.println("the prefix and suffix of given string is :");
        int high = Integer.MIN_VALUE;
        for(int i = 0;i < prefix.length;i++){

            if(prefix[i].equals(suffix[i])){
                System.out.println(prefix[i]);
                System.out.println("the length is:"+prefix[i].length());
                high = Math.max(high,prefix[i].length());
            }
        }
        System.out.println(high);
    }
 }

