public class StringConversion{
    public static void main(String[] args) {
        String s1 = "abdedf";
        String s2 = "alkmdb";
        int changes = convertS1toS2(s1,s2);
        System.out.println(changes);//4

    }
    public static int convertS1toS2(String s1,String s2){
        //first thing is to take the lcs of two strings
        int n = s1.length();
        int m = s2.length();
        int dp [][] = new int [n+1][m+1];
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int ans =  Math.abs(dp[n][m]-s1.length());
        ans+= s2.length()-dp[n][m];
        return ans;
    }
}