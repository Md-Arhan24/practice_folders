public class Creation{
    public static void main(String[] args) {
        int arr [] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        int tree [] = new int [4*n];
        createTree(arr,0,0,n-1,tree);

        //pritn tree
        print(tree);

        //get sum from range
        int sum = getSum(0,0,tree,arr);//6

        // System.out.println(sum);
        update(2,2,arr);
        createTree(arr, 0, 0, n-1, tree);
        print(tree);
        System.out.println(getSum(0, 2, tree, arr));

    }
    public static int createTree(int arr[],int treeIdx,int start,int end,int tree []){
        if(start == end){
            tree[treeIdx] = arr[start];
            return tree[treeIdx];
        }
        int mid = (start+end)/2;
        int left = createTree(arr, 2*treeIdx+1, start,mid, tree);
        int right = createTree(arr, 2*treeIdx+2, mid+1,end, tree);
        tree[treeIdx] = left+right;
        return tree[treeIdx];
    }
    public static void print(int tree[]){
        for(int a : tree){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static int getSum(int i,int j,int tree [],int arr []){
        //initally start for whole tree
        return range(0,i,j,0,arr.length-1,tree);
    }
    public static int range(int ti,int i,int j,int x,int y,int tree []){

        if(j < x || i > y)return 0;

        else if(x >= i && y <= j){
            return tree[ti];
        }else{

            //else
            int mid = (x+y)/2;
            return range(2*ti+1,i,j,x,mid,tree) + range(2*ti+2,i,j,mid+1,y,tree);
        }

        
    }
    public static void update(int i,int x,int arr[]){
        arr[i] = x;

    }
    
}