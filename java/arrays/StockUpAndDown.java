public class StockUpAndDown {
    public static int getMaxProfit(int arr[]){
       int buyPrice = Integer.MAX_VALUE;
       int maxprice = 0;
       int profit;
       for(int i = 0;i < arr.length;i++){
        if(buyPrice < arr[i]){
            profit = arr[i] - buyPrice;
            maxprice = Math.max(profit,maxprice);
        }
        else{
            buyPrice = arr[i];
        }
       }
       return maxprice;

    }
    public static void main(String[] args) {
        int arr[] = {1,4,2};
        System.out.println(getMaxProfit(arr));
    }
}
