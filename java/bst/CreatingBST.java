public class CreatingBST{

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }
    static class BST{

        //insert
        public static Node add(Node root,int data){
          if(root == null){
            return new Node(data);
          }

          if(data < root.data){
            root.left = add(root.left,data);
          }else{
            root.right = add(root.right,data);
          }

          return root;
        }

        //inorder
        public static void inorder(Node root){
            if(root == null)return;

            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        //search
        public static boolean search(Node root,int key){
            if(root == null)return false;

            if(root.data == key)return true;

            if(key < root.data){
                return search(root.left, key);
            }
            return search(root.right,key);

        }
       
    }
    public static void main(String[] args) {
        int vlaues [] = {5,1,3,4,2,7};
        Node root = null;
        BST bst = new BST();
        for(int a : vlaues){
            root = bst.add(root,a);
        }

        bst.inorder(root);
        System.out.println(bst.search(root, 0));
    }
}