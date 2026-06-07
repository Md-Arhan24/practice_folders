public class Diagnoalsum{
    public static int diagnoalSum(int arr[][]){
        //old approach
        // int firstDiag = 0;
        // int lastDiag = 0;
        // for(int i = 0;i < arr.length;i++){
        //     firstDiag+=arr[i][i];
        //     lastDiag+=arr[i][arr.length-i-1];
        // }
        // if(arr.length % 2 == 0){
        //     return firstDiag+lastDiag;
        // }else{
        //     return (firstDiag+lastDiag) - arr[arr.length/2][arr.length/2];
        // }

        //new appraoch
        int sum = 0;
         for(int i = 0;i < arr.length;i++){
            sum+=arr[i][i];
            if(i != arr.length-1-i){

            sum+=arr[i][arr.length-i-1];
            }
        }
        return sum;
        
        
    }
    public static void main(String[] args) {
        int arr [][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int diagnoal_sum = diagnoalSum(arr);
        System.out.println(diagnoal_sum);
    }
}