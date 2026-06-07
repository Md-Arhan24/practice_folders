import java.util.HashMap;
import java.util.Map;

public class FindMajority {
    //this is which approach i follow to solve this at leetcode 
    //my first approach was the below one but later got the boyersmore major algo
    public static int myFirstApproach(int nums[]){
            HashMap<Integer,Integer> s = new HashMap<>();
        //to get the count
        for(int i : nums){
            s.put(i,s.getOrDefault(i,0)+1);
        }
        //to get the max value
        int max = 0;//because the count will start from 0
        for(Integer i : s.values()){
            max = Math.max(max,i);
        }
       
        //now getting key based on value
        for(Map.Entry<Integer,Integer> e : s.entrySet()){
            if(e.getValue() == max){
                max = e.getKey();
                break;
            }

        }
        return max;
        
    }
    
    //boyers morey find major algo
    //in my case i created a hashmap and a max variable but here he doesnt creat any one
    public static int  boyersMoreyMajor(int nums[]){
        return helper(nums,0,nums[0]);
        //here we called helper with array , index 0 and first ele as ref
    }
    public static int helper(int arr[],int si,int ref){
        //more effcient - perfect use of recursion
        int count = 0;//to keep track of count
        for(int i = si;i < arr.length;i++){
            if(arr[i] == ref){
                count++;
            }else{
                count --;
            }
            if(count == -1){
                return helper(arr,i,arr[i]);
            }
        }
        return ref;
    }
    
    public static void main(String [] args){
        int arr [] = {9,9,4,4,5,5,5};

        //using my first appraoch 
        int majorRepeated = myFirstApproach(arr);
        //using boyers more
        int usingboyermore = boyersMoreyMajor(arr);
        System.out.println(usingboyermore);
        System.out.println(majorRepeated);
    }
}
