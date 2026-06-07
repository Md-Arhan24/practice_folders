public class Assingment {
    public static void printXcount(int arr[][],int key){
        int count = 0;
        for(int i= 0;i < arr.length;i++){
            for(int j = 0;j < arr[0].length;j++){
                if(arr[i][j] == key){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void secondRowsum(int arr[][]){
        int sum = 0;
        for(int j = 0; j<arr.length;j++){
            sum+=arr[arr.length-(arr.length-1)][j];
        }
        System.out.println("sum of second row is "+ sum);
    }
    //here we dont have to keep name
    public static int [][] transpose(int arr[][]){
        int temp [][] = new int [arr[0].length][arr.length];
        for(int i = 0;i < temp.length;i++){
            for(int j = 0;j < temp[0].length;j++){
                temp[i][j] = arr[j][i];
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        //print the number of 7s in 2d array
        int arr [][] = {{4,7,8},{8,8,7}};
        // printXcount(arr, 7);
        int arr2[][] = {{1,4,9},{11,4,3},{2,2,3}};
        // secondRowsum(arr2);
        int arr3[][] = {{11,12,13},{21,22,23},{31,32,33}};
        int ans [][] = transpose(arr3);
        for(int i = 0;i < ans.length;i++){
            for(int j = 0;j < ans[0].length;j++){
                System.out.print(ans[i][j] +" ");
            }
            System.out.println();
        }

    }
}
