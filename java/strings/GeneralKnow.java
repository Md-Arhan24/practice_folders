public class GeneralKnow {
    public static void main(String[] args) {
        String str = "abc";
        String st = "bca";
        String s = "ab";
        System.out.println(str.compareTo(st));//-1
        System.out.println(st.compareTo(str));//1
        System.out.println(str.compareTo(str));//0
        System.out.println(str.contains(s));//true
        System.out.println(str.replace(s, "xyz"));//xyzc //if not there return str
    }
}
