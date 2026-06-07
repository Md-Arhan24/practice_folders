public class PrintSubArrays {
    public static void printMaxOMinOFArray(int arr2[]){
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<arr2.length;i++){
            if(max < arr2[i]){
                max = arr2[i];
            }
            if(min > arr2[i] ){
                min = arr2[i];
            }
        }
     System.out.println("the max value of an array is " + max + " and minimum value is" + min);
    }
    public static int [] printSubArrays(int arr[]){
        int length = ((arr.length ) * (arr.length + 1)) / 2; 
        System.out.println(length);
        int sumOFArray [] = new int [length];
        int count = 0;
        for(int i = 0;i < arr.length;i++){
            for(int j = i; j < arr.length;j++){
                int sum = 0;
                for(int k = i; k <= j;k++){
                    sum += arr[k];
                }
                sumOFArray[count] = sum;
                count++;
            
            }
      
        }
        return sumOFArray;
    }
    public static void main(String[] args) {
        int arr[] = { 2 ,3,4,5,6};
        int arr2 [] = printSubArrays(arr);
        
        printMaxOMinOFArray(arr2);
    }
}
   