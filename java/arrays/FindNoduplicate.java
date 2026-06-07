import java.util.Arrays;

public class FindNoduplicate {
    
    // public int singleNumber(int[] nums) {
        int ele = 0;
        // Arrays.sort(nums);
        // for(int i = 0;i < nums.length;i++){
        //     System.out.println(nums[i]);
        // }
        // for(int i = 0;i < nums.length-1;i++){
        //     if(nums[i] != nums[i+1]){
                
        //         ele = nums[i];
        //     }else{
        //         i+=2;
        //     }
        // }
        // System.out.println(ele);
        // if(ele == 0){
        //     return nums[nums.length-1];
        // }else{
        //     return ele;
        // }
    // }


    public static void main(String[] args) {
        //using xor
//xor has a property which means it we get zero for identical elemetn and a xor 0 = a
//so if there are identical elemets then we get zero , but if there is no identical then we get another value
        int arr [] ={6,6,6,69};
        //unique
        int res = 0;
        for(int i : arr){
            System.out.println(res);
            res^=i;
        }
        System.out.println(res);
    }
}
