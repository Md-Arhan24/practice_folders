class ZeroOneKnapSack{
    static int max = 0;
    public static void main(String[] args) {
        int W = 4;
        int val [] = {1,2,3};
        int wt [] = {4,5,1};
       helper(W,val,wt,0,0);
       System.out.println(max);//3

    }
     public static void helper(int W,int val [],int wt [],int i,int profit){
        if(W <= 0 || i >= val.length)return;
        
        if(wt[i] <= W){
            helper(W-wt[i],val,wt,i+1,profit+val[i]);
            helper(W,val,wt,i+1,profit);
        }else{
            helper(W,val,wt,i+1,profit);
        }
        max = Math.max(max,profit);
    }
}

/*class Solution {
    int max = 0;
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        helper(W,val,wt,0,0);
        return max;
    }
    
    
   
} */