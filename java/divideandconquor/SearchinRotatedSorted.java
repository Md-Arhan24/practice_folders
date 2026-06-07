package divideandconquor;

public class SearchinRotatedSorted {
    public static int getIndex(int arr[],int k){
        //binary search
        int start = 0;
        int end = arr.length;
        while(start <= end){
            int mid = start+(end-start)/2;

            if(arr[mid] == k){
                return mid;
            }
            //direction
            if(arr[start] <= arr[mid]){
                //check left part of line one(by image) or left part of array
                if(arr[start] <= k && arr[mid] >= k){
                    end = mid;
                }else{
                    start = mid+1;
                }

            }else{
                //came on short line or right part

                //check for k lies before mid
                if(arr[mid+1] <= k && arr[end] >= k){
                    start = mid+1;
                }else{
                    end = mid;
                }
            }
        }
        return -1;

    }

    //above code in recursive fashion
    public static int getidx(int arr[],int si,int ei,int target){
        //base case
        if(si > ei){
            return -1;
        }

        int mid = si + (ei-si)/2;
        if(arr[mid] == target){
            return mid;
        }

        //check for big line or left part
        if(arr[si] <= arr[mid]){
            //case a:
            if(arr[si]<= target && target <= arr[mid]){
               return getidx(arr, si, mid -1, target);
            }else{
             return getidx(arr, mid+1, ei, target);
            }

        }

        //check for small line
        else{
            //case c
            if(arr[mid+1]<=target && target <= arr[ei]){
                return getidx(arr, mid+1, ei, target);
            }else{
                return getidx(arr, si, mid-1, target);
            }
        }
        
    }
    public static void main(String[] args) {
        int arr [] = {4,5,6,7,0,1,2};
        int index = getIndex(arr,0);
        System.out.println(index);
        System.out.println(getidx(arr, 0, arr.length-1, 0));
    }
}
