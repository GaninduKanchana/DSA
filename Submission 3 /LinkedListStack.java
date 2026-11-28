public class LinkedListStack {

    private Node top;
    private int size;

    private static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data) {

        Node newNode = new Node(data);

        newNode.next = top;
        top = newNode;

        size++;

        System.out.println(data + " pushed onto stack.");
    }

    public int pop() {

        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }

        int removed = top.data;

        top = top.next;
        size--;

        return removed;
    }

    public int peek() {

        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        Node current = top;

        System.out.print("Stack (Top to Bottom): ");

        while (current != null) {

            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped: " + stack.pop());

        stack.display();

        System.out.println("Stack size: " + stack.size());
        System.out.println("Is empty: " + stack.isEmpty());
    }
}
