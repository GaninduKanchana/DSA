public class ArrayCircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayCircularQueue(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Capacity must be greater than zero."
            );
        }

        this.capacity = capacity;
        queue = new int[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {

        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        rear = (rear + 1) % capacity;

        queue[rear] = value;
        size++;

        System.out.println(value + " inserted.");
    }

    public int dequeue() {

        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        int removed = queue[front];

        front = (front + 1) % capacity;
        size--;

        if (size == 0) {
            front = 0;
            rear = -1;
        }

        return removed;
    }

    public int peek() {

        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }


    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Queue elements: ");

        for (int i = 0; i < size; i++) {

            int index = (front + i) % capacity;

            System.out.print(queue[index] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ArrayCircularQueue queue =
                new ArrayCircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display();

        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Removed: " + queue.dequeue());

        queue.enqueue(60);
        queue.enqueue(70);

        queue.display();

        System.out.println("Front: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
    }
}
