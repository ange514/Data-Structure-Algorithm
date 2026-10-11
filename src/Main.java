
public class Main {

    // Check whether brackets are balanced
    public static boolean isBalanced(String expr) {

        if (expr == null) {
            return false;
        }

        MyStack<Character> stack = new MyStack<>();

        for (int i = 0; i < expr.length(); i++) {
            char current = expr.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (current == ')' || current == ']' || current == '}') {

                if (stack.isEmpty()) {
                    return false;
                }

                char opening = stack.pop();

                if (current == ')' && opening != '(') {
                    return false;
                }

                if (current == ']' && opening != '[') {
                    return false;
                }

                if (current == '}' && opening != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        // =====================================
        // PART 1: TEST CUSTOM LINKED LIST
        // =====================================
        System.out.println("===== PART 1: LINKED LIST =====");

        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addFirst(20);
        list.addFirst(10);
        list.addLast(30);
        list.addLast(40);

        System.out.println("List size: " + list.size());
        System.out.println("Element at index 0: " + list.get(0));
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Middle element: " + list.findMiddle());

        System.out.println("Removed first element: " + list.removeFirst());
        System.out.println("Size after removal: " + list.size());

        list.reverse();

        System.out.print("List after reversing: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();


        // =====================================
        // PART 2A: TEST CUSTOM STACK
        // =====================================
        System.out.println("\n===== PART 2A: STACK =====");

        MyStack<Integer> stack = new MyStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack is empty: " + stack.isEmpty());
        System.out.println("Stack top: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("New stack top: " + stack.peek());
        System.out.println("Stack is empty: " + stack.isEmpty());


        // =====================================
        // PART 2B: TEST QUEUE USING TWO STACKS
        // =====================================
        System.out.println("\n===== PART 2B: QUEUE =====");

        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue front: " + queue.peek());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("New queue front: " + queue.peek());

        queue.enqueue(40);

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());


        // =====================================
        // PART 2C: TEST BALANCED BRACKETS
        // =====================================
        System.out.println("\n===== PART 2C: BALANCED BRACKETS =====");

        System.out.println("{[()]} : " + isBalanced("{[()]}"));
        System.out.println("([)] : " + isBalanced("([)]"));
        System.out.println("((())) : " + isBalanced("((()))"));
        System.out.println("{[(]} : " + isBalanced("{[(]}"));
        System.out.println("Empty expression : " + isBalanced(""));
        System.out.println("Unclosed bracket : " + isBalanced("((("));
        System.out.println("Extra closing bracket : " + isBalanced("())"));
        System.out.println("Null expression : " + isBalanced(null));


        // Part 3: Arrays and Strings
        System.out.println("\n=== Part 3: Arrays and Strings ===");

        int[] numbers = {1, 2, 3, 4, 5};
        ArrayString.rotateRight(numbers, 2);

        System.out.println("Rotated array: "
                + java.util.Arrays.toString(numbers));

        System.out.println("isAnagram (listen, silent): "
                + ArrayString.isAnagram("listen", "silent"));

        int[] sortedNumbers = {1, 2, 4, 6, 8};
        int[] indices =
                ArrayString.twoSumSorted(sortedNumbers, 10);

        System.out.println("Two sum indices: "
                + java.util.Arrays.toString(indices));

        // Part 4: LRU Cache
        System.out.println("\n=== Part 4: LRU Cache ===");

        LRUCache lru = new LRUCache(2);

        lru.put(1, 10);
        lru.put(2, 20);

        System.out.println("get(1): " + lru.get(1));

        lru.put(3, 30); // Evicts key 2

        System.out.println("get(2): " + lru.get(2));
        System.out.println("get(3): " + lru.get(3));

        lru.put(4, 40); // Evicts key 1

        System.out.println("get(1): " + lru.get(1));
        System.out.println("get(3): " + lru.get(3));
        System.out.println("get(4): " + lru.get(4));

    }
}
