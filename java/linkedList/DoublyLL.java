public class DoublyLL {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size = 0;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;

    }
    public int removeFirst(){
        size--;
        if(head == null){
            return -1;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        int data = head.data;
        head = head.next;
        head.prev = null;
        return data;
    }
    public int removeLast(){
        size--;
        if(tail == null){
            return -1;
        }
         if(size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        int data = tail.data;
        tail = tail.prev;
        tail.next = null;
        return data;
    }
    public void printLL(){
        Node temp = head;
        System.out.print("null <- ");
        for(int i = 0;i < size;i++){
            int data = temp.data;
            System.out.print(data + " < - >");
            temp = temp.next;

        }
        System.out.println("null");


    }
    public static void main(String[] args) {
        DoublyLL ll = new DoublyLL();
        ll.addFirst(1);
        ll.addFirst(0);
        ll.addLast(2);
        ll.addLast(3);
        ll.printLL();
        ll.removeFirst();
        ll.removeLast();
        ll.printLL();

        
    }
}
