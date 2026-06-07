public class StringCompression {
    public static String compress(String str){
        //here we are manupulatin string multiple times so use stringBuilder
        StringBuilder sb = new StringBuilder("");
        int count = 0;//to track of frequency
        for(int i = 0;i < str.length();i++){
            count++;
            // System.out.println(count);
            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;//to move forward
            }
            if(count != 1){
                sb.append(str.charAt(i-1));//as the iteration over , we come to new char to we have to append its before one
                sb.append(count);
                
            }else{
                sb.append(str.charAt(i));
            }
            count = 0;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aaaabcdddddeaaaaaaaa";
        String edgecase = "arhan";
        String easystr = "aaabbccc";
        System.out.println(compress(str));
        System.out.println(compress(edgecase));
        System.out.println(compress(easystr));   
    }
}
