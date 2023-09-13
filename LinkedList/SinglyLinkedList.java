
public class SinglyLinkedList {

    private int size;
    public SinglyLinkedList() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    public void insertAtBeginning(int element) {
        Node node = new Node(element);
        node.next = head;
        head = node;

        if (tail == null)
            tail = head;

        size++;
    }

    public void insertAtLast(int element) {
        if (tail == null) {
            insertAtBeginning(element);
            return;
        }
        Node node = new Node(element);
        tail.next = node;
        node = tail;
        size++;
    }

    public void insertAtIndex(int index, int element) {
        if (index == 0) {
            insertAtBeginning(element);
            return;
        }
        else if (index == size) {
            insertAtLast(element);
            return;
        }
        Node temp = head;   // i -> 0
        for (int i=1; i<index; i++) {
            temp = temp.next;
        }
        Node node = new Node(element, temp.next);
        temp.next = node;
        size++;
    }

    // INSERT USING RECURSION
    public void insertUsingRecursion(int value, int index) {
        head = insertUsingRecursion(value, index, head);
    }

    private Node insertUsingRecursion(int value, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(value, node);
            size++;
            return temp;
        }
        node.next = insertUsingRecursion(value, index-1, node.next);
        return node;
    }

    public int deleteLast() {
         if (size <= 1)
             return removeFirst();

         Node secondLast = get(size - 2);
         int element = tail.value;
         tail = secondLast;
         tail.next = null;
         return element;
    }

    public int deleteParticular(int index) {
        if (index == 0)
            return removeFirst();
        else if (index == size-1)
            return deleteLast();

        Node previous = get(index-1);
        int element = previous.next.value;
        previous.next = previous.next.next;
        return element;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public Node get(int index) {
        Node node = head;
        for (int i=0; i<index; i++) {
            node = node.next;
        }
        return node;
    }

    public int removeFirst() {
        int element = head.value;
        head = head.next;

        if (head == null)
            tail = null;

        size--;
        return element;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}
