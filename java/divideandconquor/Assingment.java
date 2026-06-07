package divideandconquor;
import java.util.*;
//compare to
//if a > b return 1
//if a < b return -1

import java.util.HashMap;

public class Assingment {
    //1.write a merge sort to sort string in ascending order
    public static void megerSortStrings(String arr[],int si,int ei){
        if(si >= ei){
            return;
        }
        int mid = si +(ei - si)/2;
        megerSortStrings(arr, si, mid);
        megerSortStrings(arr, mid+1, ei);
        mergeString(arr, si,mid, ei);
    }
    public static void mergeString(String []arr,int si,int mid,int ei){
        //temp array
        String [] temp = new String[ei-si+1];

        int i = 0;
        int j = si;
        int k = mid+1;
        
        while (j <= mid && k <= ei){
            if(arr[j].compareTo(arr[k]) > 0){
                temp[i] = arr[k];
                k++;
            }else{
                temp[i] = arr[j];
                j++;
            }
            i++;
            
        }

        //reaming one
        while(j <= mid){
            temp[i++] = arr[j++];
        }
        while(k <= ei){
            temp[i++] = arr[k++];
        }

        for(int iter = 0,m = si;iter < temp.length;iter++,m++){
            arr[m] = temp[iter];
        }
    }
   
   
   //given an array print the majority element
   public static int printMajority(int arr[]){
    HashMap<Integer,Integer> table = new HashMap<>();
    for(int a:arr){
        table.put(a, table.getOrDefault(a, 0)+1);
    }

    int max = Integer.MIN_VALUE;
    int ele = -1;
    for(Map.Entry<Integer,Integer> hs : table.entrySet()){
        if(hs.getValue() > max){
            max = hs.getValue();
            ele = hs.getKey();
        }

    }
    return ele;
   }


//print the inversion count of the array , inversion count = arr[i] > arr[j] and i < j it means there is a smaller element of i
// public static int inversionCount(int arr[],int n,int count){
//     //first ask for 2 is there any samller number , then 4 ask to 1 ....so on 5 then five say i dont have return 0, then 3 say i dont have return 0 and then 1 say same and then 
//     //4 say i have 1 and 3 increse teh count to 2 then ask 2 say i have only one so increse the count to 3
    
//     //base case
//     if(n == arr.length-1){
//         return arr[n];
//     }

//     if(arr[n] >
//      inversionCount(arr, n+1, count)){
//         count+=1;
//     }
//     return count;
// }

 //by recursion
 public static int inversionCount(int arr[]){
    return inversionHelper(arr,0);
 }
 public static int inversionHelper(int arr[],int start){
    if(start == arr.length-1){
        return 0;
    }
    
    int count = 0;
    for(int i = start+1;i < arr.length;i++){
        if(arr[start] > arr[i]){
            count++;
        }
    }
    return count + inversionHelper(arr, start+1);
 }

 //ineversion using merge sort
 public static int mergerSortinversion(int arr[],int si,int ei){
    int count = 0;
    if(si >= ei){
        return count;
    }
    int mid = si +(ei - si)/2;
    
         count+=mergerSortinversion(arr, si, mid);
    count+=mergerSortinversion(arr, mid+1, ei);
   count+= merge(arr,si,mid,ei);
    
   
   return count;

 }
 public static int merge(int arr[],int si,int mid,int ei){
    //temp array
    int temp []  = new int[ei-si+1];
    int i = 0;
    int j = si;
    int k = mid+1,count = 0;
    while(j <= mid && k <= ei){
        if(arr[j] <= arr[k]){
            temp[i] = arr[j];
            j++;
        }else{
            temp[i] = arr[k];
            count+=(mid-j+1);
            k++;
        }
        i++;
    }
    while(j <= mid){temp[i++] = arr[j++];}
    while (k <= ei) {
        temp[i++] = arr[k++];

        
    }

    //assing
    for(int l = 0,m = si; l < temp.length;l++,m++){
        arr[m] = temp[l];
    }
    return count;
 }
   
    public static void main(String[] args) {
        String arr[] = { "sun", "earth", "mars", "mercury"};
        int arr3[] = {3,1,3};
        int arr2[] = {2,4,1,3,5};
        // megerSortStrings(arr, 0, arr.length-1);
        // printArr(arr);
        // System.out.println(printMajority(arr3));
        // System.out.println(inversionCount(arr2));
        System.out.println(mergerSortinversion(arr2, 0, arr2.length-1));
    }
    public static void printArr(String [] arr){
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]+" ");
        }
        System.out.println();
    }
}
