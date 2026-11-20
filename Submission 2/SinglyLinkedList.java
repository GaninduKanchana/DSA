public class SinglyLinkedList {

    private Node head;
    private int size;

    private static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

        size++;

        System.out.println(data + " inserted at beginning.");
    }

    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {

            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;

        System.out.println(data + " inserted at end.");
    }

    public int deleteFromBeginning() {

        if (head == null) {
            throw new RuntimeException("List is empty!");
        }

        int removed = head.data;

        head = head.next;
        size--;

        return removed;
    }

    public int deleteFromEnd() {

        if (head == null) {
            throw new RuntimeException("List is empty!");
        }

        if (head.next == null) {

            int removed = head.data;

            head = null;
            size--;

            return removed;
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        int removed = current.next.data;

        current.next = null;
        size--;

        return removed;
    }

    public boolean search(int value) {

        Node current = head;

        while (current != null) {

            if (current.data == value) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void display() {

        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head;

        System.out.print("Linked List: ");

        while (current != null) {

            System.out.print(current.data + " -> ");

            current = current.next;
        }

        System.out.println("null");
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtBeginning(20);
        list.insertAtBeginning(10);

        list.insertAtEnd(30);
        list.insertAtEnd(40);

        list.display();

        System.out.println("Search 30: " + list.search(30));

        System.out.println(
                "Deleted from beginning: "
                + list.deleteFromBeginning()
        );

        System.out.println(
                "Deleted from end: "
                + list.deleteFromEnd()
        );

        list.display();

        System.out.println("Size: " + list.size());
    }
}
