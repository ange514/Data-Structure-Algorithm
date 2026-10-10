public class MyLinkedList<T> {

        // Node represents one element in the linked list
        private static class Node<E> {
            E data;
            Node<E> next;

            Node(E data) {
                this.data = data;
                this.next = null;
            }
        }

        private Node<T> head;
        private Node<T> tail;
        private int size;

        // Constructor
        public MyLinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        // Add an element at the beginning
        public void addFirst(T data) {
            Node<T> newNode = new Node<>(data);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }

            size++;
        }

        // Add an element at the end
        public void addLast(T data) {
            Node<T> newNode = new Node<>(data);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            size++;
        }

        // Remove and return the first element
        public T removeFirst() {
            if (head == null) {
                throw new IllegalStateException("The list is empty.");
            }

            T removedData = head.data;
            head = head.next;
            size--;

            if (head == null) {
                tail = null;
            }

            return removedData;
        }

        // Get an element at a specific index
        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException(
                        "Invalid index: " + index
                );
            }

            Node<T> current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current.data;
        }

        // Return the number of elements
        public int size() {
            return size;
        }

        // Reverse the list in place
        public void reverse() {
            Node<T> previous = null;
            Node<T> current = head;
            Node<T> nextNode;

            tail = head;

            while (current != null) {
                nextNode = current.next;
                current.next = previous;
                previous = current;
                current = nextNode;
            }

            head = previous;
        }

        // Find the middle element using slow and fast pointers
        public T findMiddle() {
            if (head == null) {
                throw new IllegalStateException("The list is empty.");
            }

            Node<T> slow = head;
            Node<T> fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow.data;
        }
    }

