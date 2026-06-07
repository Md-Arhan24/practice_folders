class ContainsDuplicate{
    
    static{
        for(int i=0;i<=1;i++){
             boolean ans = containsDuplicate(new int[]{2, 1, 0,9,5,4,3,2,9});
             System.out.println(ans);
        }
        
    }
    public static boolean containsDuplicate(int[] nums) {
        for(int i = 1; i<nums.length; i++){
            int key = nums[i];
            int j = i - 1;
            while(j>=0 && nums[j] > key){
                nums[j+1] = nums[j];
                j--;
            }
            if(j>=0 && nums[j] == key)
                return true;
            nums[j+1] = key;
        }
        return false;
    }
    public static void main(String[] args) {
        
    }

}