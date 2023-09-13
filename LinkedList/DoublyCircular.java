public class DoublyCircular {
    private Node head;
    private Node tail;

    private class Node<T> {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void addToFront(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
    }

    public void addToEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Doubly Circular Linked List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.print(head.data + " (HEAD)");
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyCircular list = new DoublyCircular();

        list.addToFront(1);
        list.addToFront(2);
        list.addToEnd(3);
        list.addToEnd(4);

        System.out.println("Doubly Circular Linked List:");
        list.display();
    }
}
