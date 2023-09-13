
public class CircularLinkedList_Main {
    public static void main(String[] args) {

        CircularLinkedList cList = new CircularLinkedList();
        cList.insert(5);
        cList.insert(30);
        cList.insert(31);
        cList.insert(62);

        cList.display();

        cList.delete(31);
        cList.display();
    }
}
