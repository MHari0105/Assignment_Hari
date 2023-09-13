
public class SinglyLinkedList_Main {
    public static void main(String[] args) {

        SinglyLinkedList sList = new SinglyLinkedList();
        sList.insertAtBeginning(3);
        sList.insertAtBeginning(4);
        sList.insertAtBeginning(16);
        sList.insertAtBeginning(7);
        sList.insertAtLast(5);
        sList.insertAtIndex(3, 100);
        sList.display();

        System.out.println("\nFirst element : " + sList.removeFirst());
        sList.display();

        System.out.println("\nLast Element : " + sList.deleteLast());
        sList.display();

        System.out.println("\nIndex : " + sList.deleteParticular(1));
        sList.display();

        System.out.println("\nInsert using Recursion");
        sList.insertUsingRecursion(88, 2);
        sList.display();
    }
}