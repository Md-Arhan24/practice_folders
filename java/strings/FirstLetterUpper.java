public class FirstLetterUpper {
    public static String makeUpper(String str){
        //first here we have to manipulate string multiple times so string builder
        StringBuilder sb = new StringBuilder("");
        
        //first char we know should be convert to uppercase
        sb.append(Character.toUpperCase(str.charAt(0)));

        for(int i = 1;i < str.length();i++){
            if(str.charAt(i) == ' ' && i < str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        //at last we have to convert it to string object
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "hi, i am arhan";
        System.out.println(makeUpper(str));
    }
}
