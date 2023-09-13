
public class DoublyLinkedList_Main {
    public static void main(String[] args) {

        DoublyLinkedList dList = new DoublyLinkedList();

        dList.insertFirst(18);
        dList.insertFirst(62);
        dList.insertFirst(56);
        dList.insertFirst(34);
        dList.insertLast(90);
        dList.insert(62, 5);
        dList.display();
    }
}
