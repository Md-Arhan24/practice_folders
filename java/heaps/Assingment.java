import java.util.*;
public class Assingment{
    public static int getTimeToFillEmptySlots(ArrayList<Integer> arr,int n,int k){
        //first sort
        Collections.sort(arr);

        int maxTime = 0;
        //interate over arr, and get the max ajacend dist
        for(int i = 1;i < k;i++){
            maxTime = Math.max(maxTime,arr.get(i)-arr.get(i-1)-1);
        }

        //compare iwth first and last
        maxTime = Math.max(maxTime,arr.get(0)-1);
        maxTime = Math.max(maxTime,n-arr.get(k-1));
        maxTime--;
        return maxTime;
    }
    public static void main(String[] args) {
        int n = 6;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(6);
        int k = arr.size();
        System.out.println(getTimeToFillEmptySlots(arr,n,k));

    }
}