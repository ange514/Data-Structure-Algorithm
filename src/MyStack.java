public class MyStack<T> {

        private MyLinkedList<T> list;

        // Constructor
        public MyStack() {
            list = new MyLinkedList<>();
        }

        // Add an element to the top
        public void push(T data) {
            list.addFirst(data);
        }

        // Remove and return the top element
        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty.");
            }

            return list.removeFirst();
        }

        // Return the top element without removing it
        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty.");
            }

            return list.get(0);
        }

        // Check whether the stack is empty
        public boolean isEmpty() {
            return list.size() == 0;
        }
    }

