public class RotatedAns {
    public static boolean check(int[] nums) {
        // write your code here
        boolean sorted = false;
        int last = -1;
        int arr [] = new int[nums.length];
        for(int j = 0;j < nums.length;j++){
            
        if(j == 0){

            last = nums[nums.length-1];
        }else{
            last = arr[nums.length-1];
        }
        
        for(int i = 1;i < nums.length;i++){
          
           if(j == 0){

            arr[i] = nums[i-1];
        }else{
            arr[i] = nums[i-1];
        }
          
          
                
            }
            arr[0] = last;
            print(arr);
            if(compare(arr,nums)){
                sorted = true;
            }
            
        }
        return sorted;
    }
    public static boolean compare(int n[],int j[]){
        boolean ans = true;
        for(int i = 0;i < n.length;i++){
            if(n[i] != j[i]){
                ans = false;
            }
            else{
                ans = true;
            }
        }
        return ans;
    }
    public static void print(int arr[]){
        for(int i = 0;i< arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int a [] = {1,2,3,4,9};
        System.out.println(check(a));
    }
}
