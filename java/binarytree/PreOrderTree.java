import java.util.LinkedList;
import java.util.Queue;

public class PreOrderTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        // build function - return root node
        public static Node buildTree(int index[]) {
            // first increse the idx;
            idx++;
           
            if (index[idx] == -1) {
                return null;
            }

            // create a new node
            Node newNode = new Node(index[idx]);
            // assinging value to left node or conntecting it
            newNode.left = buildTree(index);
            newNode.right = buildTree(index);
            // remember heree we notice the pattern of how recursive tree will be made,
            // first it go for left then right, same here as well.
            return newNode;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                // we are at leaf or our tree is empty
                System.out.print("-1 ");
                return;
            }
            // rule 1 print root
            System.out.print(root.data + " ");
            // rule 2 call for left
            preOrder(root.left);
            // rule 3 call for right
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrderTraversal(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                Node curr = q.remove();
                Node currLeft = curr.left;
                Node currRight = curr.right;
                if (currLeft != null) {
                    q.add(currLeft);
                }
                if (currRight != null) {
                    q.add(currRight);
                }
                System.out.print(curr.data + " ");

            }

        }

        public static void levelWiseBinaryTree(Node root) {
            if (root == null)
                return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node curr = q.remove();
                if (curr != null) {
                    System.out.print(curr.data+" ");
                    Node currLeft = curr.left;
                    Node currRight = curr.right;
                    if (currLeft != null) {
                        q.add(currLeft);
                    }
                    if (currRight != null) {
                        q.add(currRight);
                    }
                }else{
                    //curr node is qual to null
                    System.out.println();
                    if(!q.isEmpty()){
                        q.add(null);
                    }else{
                        //queue is empty
                        break;
                    }
                }

            }
        }
        public static void printKthlevel(Node root,int level,int k){
            if(root == null){
                return;
            }
            printKthlevel(root.left, level+1,k);
            if(level == k){
                System.out.print(root.data +" ");
            }
            printKthlevel(root.right, level+1, k);
        }

        //level order for level wise
        public static void levelOrderforKlevel(Node root,int k){
            if(root == null){
                return;
            }
            int level = 1;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                if(level == k){
                        while(!q.isEmpty() && q.peek() != null){
                            System.out.print(q.remove().data+" ");
                        }
                        break;
                    }
                Node curr = q.remove();
                if(curr == null){
                    level+=1;
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                   if(curr.left != null){
                    q.add(curr.left);
                   }
                   if(curr.right != null){
                    q.add(curr.right);
                   }
                }
            }
        }

        //lca - appraoch 2
        public static Node lca2(Node root,Node n1,Node n2){
            //base case - if root is null return null (root), or root is n1 or n2 then return root.
            //ask hey root, are you n1 or n2 or null
            if(root == null || root.data == n1.data || root.data == n2.data){
                return root;
            }

            //then ask for root that check in your left child and right child.
           Node left =  lca2(root.left,n1,n2);
           Node right = lca2(root.right,n1,n2);

           //then if left say i have not found, then return right,(because it might have the node)
           if(left == null){
                return right;
           }

           if(right == null){
            //i dont have , return left
            return left;
           }

           //root : my left have not found, my right also not found , so it should return my self.
           return root;

        }

    public Node removeLeafNodes(Node root, int target) {
        if (root == null) {
            return null;
        }

        removeLeafNodes(root.left, target);
        removeLeafNodes(root.right, target);

        if ((root.left == null && root.right == null) && root.data == target) {
            root = null;
        }
        return root;
    
}

    }

    public static void main(String[] args) {
        int index[] = {1,2,2,-1,-1,2,-1,-1,3,-1,6,-1,-1};
        /*
                     1
                   /   \
                 2       3
                / \     /  \
               2   2   null  6
              / \  / \       / \
         null   null  null  null null

        
        */
        BinaryTree bt = new BinaryTree();
        // return root
        Node root = bt.buildTree(index);
        Node n1 = new Node(3);
        Node n2 = new Node(6);
        // System.out.println(root.data);
        // bt.preOrder(root);
        // bt.inOrder(root);
        // bt.postOrder(root);
        // bt.levelOrderTraversal(root);
        // bt.levelWiseBinaryTree(root);
        //write for k the level print
        // bt.printKthlevel(root,1,2);//2 3
        // bt.levelOrderforKlevel(root, 1);//1
    //    System.out.println(bt.lca2(root,n1 , n2).data);
    Node afterRoot = bt.removeLeafNodes(root, 2);
    bt.preOrder(afterRoot);



    }
}