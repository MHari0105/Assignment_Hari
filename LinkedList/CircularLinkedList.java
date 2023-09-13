
public class CircularLinkedList {

    private class Node {
        int value;
        Node next;

        public Node(int value) { this.value = value; }
    }

    private Node head;
    private Node tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void delete(int value) {
        Node node = head;
        if (node == null)
            return;
        if (node.value == value) {
            head = head.next;
            tail.next = head;
            return;
        }
        do {
            Node temp = node.next;
            if (temp.value == value) {
                node.next = temp.next;
                break;
            }
            node = node.next;
        } while (node != head);
    }

    public void display() {
        Node node = head;
        if (head != null) {
            do {
                System.out.print(node.value + " -> ");
                node = node.next;
            } while (node != head);
        }
        System.out.print(head.value + " (HEAD)");
        System.out.println();
    }
}
