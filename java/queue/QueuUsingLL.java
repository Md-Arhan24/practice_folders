public class QueuUsingLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class QueueLL {
        static Node head = null;
        static Node tail = null;

        // public static boolean isEmpty() {
        //     return head == null;
        // }
        public static boolean isEmpty(){
            return head == null & tail == null;
        }

        public static void add(int data) {
            // first node
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = tail.next;
        }

        public static int remove() {
            // if is iempty
            if (isEmpty()) {
                System.out.println("list is emtpy");
                return -1;
            }

            // if single node
            int data = head.data;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;

            }

            return data;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }

            return head.data;
        }

    }

    public static void main(String[] args) {
        QueueLL q = new QueueLL();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.peek());
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }

}