
public class LinkedListFIFOQueue {

    private Node front;
    private Node rear;
    private int size;

    private static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add an element to the rear
    public void enqueue(int data) {

        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;

        System.out.println(data + " added to queue.");
    }

    // Remove an element from the front
    public int dequeue() {

        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        int removed = front.data;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;

        return removed;
    }

    // View the front element
    public int peek() {

        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        return front.data;
    }

    // Check whether queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Return queue size
    public int size() {
        return size;
    }

    // Display queue elements
    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        Node current = front;

        System.out.print("Front -> ");

        while (current != null) {

            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("Rear");
    }

    public static void main(String[] args) {

        LinkedListFIFOQueue queue =
                new LinkedListFIFOQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Front element: " + queue.peek());

        System.out.println("Dequeued: " + queue.dequeue());

        queue.display();

        queue.enqueue(40);

        queue.display();

        System.out.println("Queue size: " + queue.size());
        System.out.println("Is empty: " + queue.isEmpty());
    }
}
