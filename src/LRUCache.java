
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class Node {
        int key;
        int value;
        Node previous;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;

    // Dummy nodes simplify adding and removing entries.
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.previous = head;
    }

    // Get a value and mark its entry as recently used.
    // Returns -1 if the key does not exist.
    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) {
            return -1;
        }

        moveToFront(node);
        return node.value;
    }

    // Insert or update an entry.
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        Node existing = cache.get(key);

        if (existing != null) {
            existing.value = value;
            moveToFront(existing);
            return;
        }

        Node node = new Node(key, value);
        cache.put(key, node);
        addToFront(node);

        if (cache.size() > capacity) {
            Node leastRecentlyUsed = removeLast();
            cache.remove(leastRecentlyUsed.key);
        }
    }

    // Insert a node immediately after head.
    private void addToFront(Node node) {
        node.next = head.next;
        node.previous = head;

        head.next.previous = node;
        head.next = node;
    }

    // Remove a node from the doubly linked list.
    private void remove(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    // Move an existing node to the most recently used position.
    private void moveToFront(Node node) {
        remove(node);
        addToFront(node);
    }

    // Remove and return the least recently used node.
    private Node removeLast() {
        Node node = tail.previous;
        remove(node);
        return node;
    }
}
