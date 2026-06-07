public class FindTheLastOcurrence{
    public static int getLast(int arr[],int k,int i){
        //if we iterate from backword then we dont have to make any variabe
        if(i < 0){
            return -1;
        }
        if(arr[i] == k){
            return i;
        }
        
       return getLast(arr, k, i-1);
        
    }
    
    //others appraoch
    public static int getLast2(int arr[],int i,int k){
        if(i == arr.length){
            return -1;
        }
        //checking for next any
        int isFound = getLast2(arr, i+1, k);

        if(isFound == -1&& arr[i] == k){
            return i;
        }
        // if(arr[i] == k){
        //     //see is there any element upcoming array
        //     return getLast2(arr, i+1, k);
        // }
        return isFound;
    }

    public static void main(String []args){
        int arr [] = {1,2,3,4,6,6,4};
        System.out.println(getLast2(arr,0,6));
    }
}