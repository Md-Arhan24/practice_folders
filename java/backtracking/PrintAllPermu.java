public class PrintAllPermu{
  

    //shardha code
    public static void printpermutaion1(String str,String ans){
        //base case - we run till str becomes empty
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        //loop to iterate over stirng
        for(int i = 0;i < str.length();i++){
            //take the first char
            char c = str.charAt(i);
            //remvoe the take char by using substring
            String nstr = str.substring(0, i)+str.substring(i+1);//we created new string becuase if we changes in the old string then it will recude and our loop wont execute entierly.
            printpermutaion1(nstr,ans+c);
            
        }
    }


    //leetcode problem - does permutation of a exists in b
    public static boolean checkpermu(String str,String check,String demo){
        boolean value = false;
        if(str.length() == 0){
            if(check.contains(demo)){
                return true;
               
            }else{
                return false;
            }
        }

        for(int i = 0;i < str.length();i++){
            char c = str.charAt(i);
            String newst = str.substring(0, i) + str.substring(i+1);
            value =checkpermu(newst, check, demo+c);
            if(value){
                
                return value;
            }
               
            
        }
        return value;
        
        
    }
    public static boolean doesExists(String str,String str2){
        return checkpermu(str,str2,"");
    }
    

    public static void main(String[] args) {
        String str = "abc";
        // printpermutaion(str,0,"");
        // printpermutaion1(str, "");
        System.out.println(doesExists("ab","eidbaooo"));
    }
}