import java.util.Stack;

public class StackQueueDequeueFriendly {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackQueueDequeueFriendly() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }


    public void enqueue(int value) {

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(value);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        System.out.println(value + " added to queue.");
    }


    public int dequeue() {

        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        return stack1.pop();
    }

    public int peek() {

        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public int size() {
        return stack1.size();
    }

    public static void main(String[] args) {

        StackQueueDequeueFriendly queue =
                new StackQueueDequeueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front: " + queue.peek());

        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Removed: " + queue.dequeue());

        queue.enqueue(40);

        System.out.println("Front: " + queue.peek());
        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Removed: " + queue.dequeue());

        System.out.println("Queue empty: " + queue.isEmpty());
    }
}
