public class CircularDoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        int data;
        Node previous;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
            newNode.previous = newNode;
        } else {
            newNode.next = head;
            newNode.previous = tail;

            head.previous = newNode;
            tail.next = newNode;

            head = newNode;
        }

        size++;
    }

    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
            newNode.previous = newNode;
        } else {
            newNode.previous = tail;
            newNode.next = head;

            tail.next = newNode;
            head.previous = newNode;

            tail = newNode;
        }

        size++;
    }

    public int deleteFromBeginning() {

        if (head == null) {
            throw new RuntimeException("List is empty!");
        }

        int removed = head.data;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.previous = tail;
            tail.next = head;
        }

        size--;
        return removed;
    }

    public int deleteFromEnd() {

        if (head == null) {
            throw new RuntimeException("List is empty!");
        }

        int removed = tail.data;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = head;
            head.previous = tail;
        }

        size--;
        return removed;
    }

    public boolean search(int value) {

        if (head == null) {
            return false;
        }

        Node current = head;

        do {
            if (current.data == value) {
                return true;
            }

            current = current.next;

        } while (current != head);

        return false;
    }

    public void displayForward() {

        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head;

        System.out.print("Forward: ");

        do {
            System.out.print(current.data + " <-> ");
            current = current.next;

        } while (current != head);

        System.out.println("(back to head)");
    }

    public void displayBackward() {

        if (tail == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = tail;

        System.out.print("Backward: ");

        do {
            System.out.print(current.data + " <-> ");
            current = current.previous;

        } while (current != tail);

        System.out.println("(back to tail)");
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        CircularDoublyLinkedList list =
                new CircularDoublyLinkedList();

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
