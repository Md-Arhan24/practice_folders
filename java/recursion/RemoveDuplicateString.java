public class RemoveDuplicateString {
    public static String removeDuplicates(String str,int i,String newStr){
        if(i == str.length()){
            return newStr;
        }
        if(!newStr.contains(String.valueOf(str.charAt(i)))){
            newStr+=str.charAt(i);
        }
        return removeDuplicates(str, i+1, newStr);

    }
    public static void main(String[] args) {
        String str = "apnacollege";
        System.out.println(removeDuplicates(str,0,""));
    }
}
