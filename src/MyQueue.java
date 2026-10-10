
public class MyQueue<T> {

    private MyStack<T> inStack;
    private MyStack<T> outStack;

    // Constructor
    public MyQueue() {
        inStack = new MyStack<>();
        outStack = new MyStack<>();
    }

    // Add an element to the rear of the queue
    public void enqueue(T data) {
        inStack.push(data);
    }

    // Move elements when outStack is empty
    private void transfer() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    // Remove and return the front element
    public T dequeue() {
        transfer();

        if (outStack.isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        return outStack.pop();
    }

    // Return the front element without removing it
    public T peek() {
        transfer();

        if (outStack.isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        return outStack.peek();
    }
}

