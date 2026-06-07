public class LinkedList {
    // created a class node
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // head and tail
    public static Node head;
    public static Node tail;
    public static int size = 0;

    // addFirst
    public void addFirst(int data) {
        size++;
        // create a node
        Node newNode = new Node(data);

        // case-1 if no LL is exists
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;// step 2 make newNode points to head
        head = newNode;// 3 make the new node as head.
    }

    // addLast
    public void addLast(int data) {
        size++;
        Node newNode = new Node(data);

        // if list is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;// point next of tail to new node
        tail = newNode;// make newNode as tail.
    }

    // print the LL
    public void print() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node temp = head;
       
        while (temp != null) {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
        System.out.println("Linked List successfully printed");

    }

    //addinmiddle
    public void addMiddle(int idx,int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        int i = 0;
        Node temp = head;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        Node newNode = new Node(data);
         size++;//here we not add the size at top beacuse as if the idx is zero we call add first , it will increse here and addFirst as well if we add it at top.
        newNode.next = temp.next;
        temp.next = newNode;


    }

    //remove node from first
    public int removeFirst(){
        //if list is empty
        if(size == 0){
            System.out.println("list is emtpy");
            return 0;
        }
        else if(size == 1){
            int data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    //remove last
    public int removeLast(){
        if(size == 0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int data = head.data;
            head = tail = null;
            return data;
        }

        Node prev = head;
        while(prev.next != tail){
            prev = prev.next;
        }
        int data = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return data;
    }
    public int search(int data){
        if(size == 0){
            System.out.println("list is empty");
            return -1;
        }
        Node temp = head;
        // int idx = -1;
        // while(temp.next != null){
        //     idx++;
        //     if(temp.data == data){
        //         return idx;
        //     }
        //     temp = temp.next;

        // }
        for(int i = 0;i < size;i++){
            if(temp.data == data){
                return i;
            }
            temp= temp.next;
        }
        return -1;
    }
    //search using recursion
    public int recursiveSearch(int key,Node temp,int idx){
        if(temp == null){
            return -1;
        }
        if(temp.data == key){
            return idx;
        }
        return recursiveSearch(key, temp.next, idx+1);
    }
    public void reverseLL(){
        if(size == 0){
            System.out.println("list is empty");
            return;
        }

        //3 var
        Node prev = null,curr= tail =  head,next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
       
        
    }
    //remove nth node form end
    public int removeNthNode(int n){
        if(n == size){
            int data = head.data;
            head = head.next;
            return data;
        }
        int idx = size-n+1;
        Node curr = head;
        for(int i = 1;i < idx-1;i++){
            curr = curr.next;
        }
        int data = curr.next.next.data;
        curr.next = curr.next.next;
        return data;

    }
    //to get the data
    public int getData(int idx){
        Node temp = head;
        int tempIdx = 1;
        while(tempIdx < idx){
            temp = temp.next;
            tempIdx++;
        }
        return temp.data;
    }

    //check if LL is palindrome - my appraoch tle
    public boolean isLLPalindrome(){
        Node start = head;
        Node end = head;//here i can also use tail directly but here i am coding for leetcode problem
        int idx = 1;//becuase my below loop run size -1 , so initlialy i start at one.
        while(end.next != null){
            end = end.next;
            idx++;
        }
        for(int i = 0;i < idx/2;i++){
            if(start.data != getData(size-i)){
                return false;
            }
            start = start.next;
        }
     
        return true;

        
    }
    
    //shardha appraoch
    //steps fimd mid , 2. reverse the seocnd part , 3 . use start and end pointers
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
            //even-case           //odd - case
        while(fast != null && fast.next != null){
            slow = slow.next;//+1
            fast = fast.next.next;//+2
        }
        return slow;
    }

    public Node reverseTheLL(Node mid){
        Node prev = null,curr = mid,next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    //now check
    public boolean isLLPalindromeOptimize(Node head){
        Node middle = findMid(head);
        Node secondHalfHead = reverseTheLL(middle);
        Node start = head;
        while(secondHalfHead != null){
            if(start.data != secondHalfHead.data){
                return false;
            }
            start = start.next;
            secondHalfHead = secondHalfHead.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.print();
        // System.out.println(size);
        // ll.addMiddle(3,19);
        // ll.print();
        // System.out.println(size);
        // System.out.println(ll.removeFirst());
        // System.out.println(ll.removeLast());
        // ll.print();
        // System.out.println(ll.search(4));//1
        // System.out.println(ll.recursiveSearch(199, head, 0));//0
        // ll.reverseLL();
        // ll.print();
        // ll.removeNthNode(5);
        // ll.print();
        // ll.isLLPalindrome();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(4);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
        ll.print();
        System.out.println(ll.isLLPalindrome());
        System.out.println(ll.isLLPalindromeOptimize(head));

    }
}