class AVltree{
    static class Node{
        int data;
        int height;//it help to calculate bf
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.height = 1;
            //by default the nodes left and right are intlized with null
        }
    }
    static Node root;//this root value is intilzed in main function
    //insert
    public static Node insertAVL(Node root,int key){
        if(root == null){
            return new Node(key);//create a new root and return
        }

        //insert at it appropriate position
        if(key < root.data){
            root.left = insertAVL(root.left, key);
        }else if(key > root.data){
            root.right = insertAVL(root.right, key);
        }else{
            //no duplicates are allowed
            return root;
        }

       
        root.height = Math.max(getHeight(root.left),getHeight(root.right))+1;//dont access root.left.height, because we want balanced factor height which is left - right height.
        //first calculate height, so that we can calculate bf

        int bf = getBalancedFactor(root);
        //left of left case
        if(bf > 1 && key < root.left.data){
            // Node newNode = rotateRight(root);
            // return newNode;
            //or
            return rotateRight(root);
        }

        //right of right case
        if(bf < -1 && key > root.right.data){
            // Node newNode = rotateLeft(root);
            // return newNode;
            // or
            return rotateLeft(root);
        }

        //right of left case
        if(bf < -1 && key < root.right.data){
            //two rotations
           root.right = rotateRight(root.right);
           return rotateLeft(root);
        }
        

        //left of right case
        if(bf > 1 && key > root.left.data){
           root.left = rotateLeft(root.left);
           return rotateRight(root);
        }

        
        return root;
    }
    public static Node rotateLeft(Node x){
        //here we only came x value, so we have to get y and t2 as well.
        Node y = x.right;
        Node t2 = y.left;
        /*
         x                  y
          \                /
           y---------->   x
         /                 \
        t2                 t2
        
        */
        
        y.left = x;
        x.right = t2;

        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;
        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;

        return y;

    }
    public static Node rotateRight(Node y){
        Node x = y.left;
        Node t2 = x.right;
         /*  we have to make from ( this to this )
          y             x
         /               \
        x ---------->     y
        \                / 
         t2             t2
        
        */



        x.right = y;
        y.left = t2;

        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;//update first childs then parent
        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1; //update paretn

        return x;
    }

    //balancef factor
    public static int getBalancedFactor(Node root){
        if(root == null)return 0;
        return getHeight(root.left) - getHeight(root.right);
    }

    //height
    public static int getHeight(Node root){
        if(root == null)return 0;
        return root.height;
    }
    public static void main(String[] args) {
        //if order is [40,20,10,25,30,22,50]
        root = insertAVL(root, 40);
        root = insertAVL(root, 20);
        root = insertAVL(root, 10);
        root = insertAVL(root, 25);
        root = insertAVL(root, 30);
        root = insertAVL(root, 22);
        root = insertAVL(root, 50);

        /*
           25
	     /    \
	    20    40 
	   /  \   /  \   
	  10   22 30  50
        
        */

      preorder(root);//25 20 10 22 40 30 50
      //getting : 30 20 10 25 22 40 50  (wrong)//this is correct if we insert in order like 10,20,30,40,50,25,22

    }
    public static void preorder(Node root){
        if(root == null)return;
        System.out.print(root.data +" ");
        preorder(root.left);
        preorder(root.right);
    }
}