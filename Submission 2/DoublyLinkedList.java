public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private static class Node {

        int data;
        Node previous;
        Node next;

        Node(int data) {

            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        if (head == null) {

            head = newNode;
            tail = newNode;

        } else {

            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        size++;

        System.out.println(data + " inserted at beginning.");
    }

    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (tail == null) {

            head = newNode;
            tail = newNode;

        } else {

            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
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

        if (head == null) {
            tail = null;
        } else {
            head.previous = null;
        }

        size--;

        return removed;
    }

    public int deleteFromEnd() {

        if (tail == null) {
            throw new RuntimeException("List is empty!");
        }

        int removed = tail.data;

        tail = tail.previous;

        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }

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

    public void displayForward() {

        Node current = head;

        System.out.print("Forward: ");

        while (current != null) {

            System.out.print(current.data + " <-> ");

            current = current.next;
        }

        System.out.println("null");
    }

    public void displayBackward() {

        Node current = tail;

        System.out.print("Backward: ");

        while (current != null) {

            System.out.print(current.data + " <-> ");

            current = current.previous;
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

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtBeginning(20);
        list.insertAtBeginning(10);

        list.insertAtEnd(30);
        list.insertAtEnd(40);

        list.displayForward();
        list.displayBackward();

        System.out.println("Search 30: " + list.search(30));

        System.out.println(
                "Deleted from beginning: "
                + list.deleteFromBeginning()
        );

        System.out.println(
                "Deleted from end: "
                + list.deleteFromEnd()
        );

        list.displayForward();
        list.displayBackward();

        System.out.println("Size: " + list.size());
    }
}
