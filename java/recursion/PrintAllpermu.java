public class PrintAllpermu {
    public static void printAll(int arr[],int n){
        if(n == arr.length){
            for(int a : arr){
                System.out.print(a+" ");
            }
            System.out.println();
            return;
        }

        for(int i = n;i < arr.length;i++){
            swap(arr,n,i);
            printAll(arr, n+1);
            swap(arr,n,i);
        }

    }
    //or
    public static void printallLater(int arr[],boolean visited[],String str){
        if(arr.length == str.length()){
            System.out.println(str);
            return;
        }

        for(int i = 0;i < arr.length;i++){
           if(!visited[i]){
             visited[i] = true;
            printallLater(arr, visited, str+arr[i]);
            visited[i] = false;
           }
        }
    }
    public static void swap(int arr[],int i,int j){
    //    arr[i] = arr[i]^arr[j];
    //    arr[j] = arr[i]^arr[j];
    //    arr[i] = arr[i]^arr[j];
        int temp = arr[i];
        arr[i] =arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int n []= {0,1,2};
        printAll(n,0);
        printallLater(n, new boolean [n.length], "");
    }
}
