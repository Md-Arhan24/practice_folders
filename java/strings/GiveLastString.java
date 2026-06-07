public class GiveLastString{
    public static void main(String[] args) {
        String s = "132";

        // while(s.length() > 1){
        //     char first = s.charAt(0);
        //     char second = s.charAt(1);
        //     System.out.println(first +" "+second);
        //     s = s.replace(s.charAt(0), second);
        //     System.out.println(s);
        //     s = s.replace(s.charAt(1), first);
        //     System.out.println(s);
        //     s = s.substring(0, s.length()-1);
        //     System.out.println(s);
        //     break;
        // }
        System.out.println("arhan".replaceFirst(s.substring(0, 2),"b"));
    }
}