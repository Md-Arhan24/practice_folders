public class CountingSort{
    public static void countingSort(int arr[]){
        //creating count array
        int count [] = new int[arr.length+1];
        for(int i = 0;i < arr.length;i++){
            if(count[arr[i]] != 0){
                count[arr[i]]+=1;
            }else{
                count[arr[i]] = 1;
            }
        }
        
        //now answer array
        int ans [] = new int[arr.length];
         int j = 0;
        for(int i = 0;i <=arr.length;i++){
            // int idx = arr[i];
            // int frequency = count[idx];
            // System.out.println(idx +" freq" + frequency);
           
            while(count[i] > 0){

                ans[j] = i;
                // System.out.println(j + " "+ans[j]);
                
                count[i]--;
                j++;

            }
        }
        print(ans);
    }
    public static void print(int arr[]){
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    public static void countsortBYshardha(int arr[]){
        //here we have taken the large value because in count we make index until the largest value
        //so we taken here.
        int large = Integer.MIN_VALUE;
        //get large value
        for(int i = 0;i < arr.length;i++){
            large = Math.max(large,arr[i]);
        }

        //count array here length will be +1 because we considerd 0 also as positive
        int count [] = new int[large+1];
        for(int i = 0;i<arr.length;i++){
            //iterating over given array and using it value as index to increament here
            count[arr[i]]++;
        }
        int j = 0;
        for(int i = 0;i < count.length;i++){
            
            while(count[i] > 0){
                arr[j] = i;
                count[i]--;
                j++;
            }
        }
        print(arr);
    }
    public static void main(String[] args) {
        int arr []= {5,4,1,4,3,2,6};
        // countingSort(arr);
        // print(arr);
        countsortBYshardha(arr);
    }
}