# Data Structures and Algorithms Assignment

## 1. Project Overview

This project implements fundamental data structures and algorithms using Java without relying on built-in linked-list implementations for the custom data structures.

The project covers:

- Singly linked list
- Stack implemented using a linked list
- Queue implemented using two stacks
- Balanced bracket checking
- Array rotation
- Anagram checking
- Two-sum search on a sorted array
- Least Recently Used (LRU) cache using a HashMap and a custom doubly linked list

## 2. Complexity Report

### Part 1: Linked List

Let `n` represent the number of elements in the linked list.

| Method | Time Complexity | Extra Space | Explanation |
|---|---|---|---|
| `addFirst(T value)` | O(1) | O(1) | Adds a node at the beginning without traversing the list. |
| `addLast(T value)` | O(n) | O(1) | Traverses the list to locate the last node. |
| `removeFirst()` | O(1) | O(1) | Removes the first node by updating the head reference. |
| `get(int index)` | O(n) | O(1) | Traverses the list until the requested index is reached. |
| `size()` | O(1) | O(1) | Returns the stored size counter. |
| `reverse()` | O(n) | O(1) | Reverses node links in place using a single traversal. |
| `findMiddle()` | O(n) | O(1) | Uses slow and fast pointers to locate the middle node. |

**Real-world application:** Linked lists are useful in systems that need efficient insertion and removal of elements, such as maintaining ordered tasks or managing nodes in an LRU cache.

### Part 2: Stack, Queue, and Balanced Brackets

Let `n` represent the number of elements or characters processed.

| Method | Time Complexity | Extra Space | Explanation |
|---|---|---|---|
| `push(T value)` | O(1) | O(1) per insertion | Adds an element to the top of the stack. |
| `pop()` | O(1) | O(1) | Removes and returns the top element. |
| `peek()` | O(1) | O(1) | Reads the top element without removing it. |
| `isEmpty()` | O(1) | O(1) | Checks whether the stack contains elements. |
| `enqueue(T value)` | O(1) | O(1) per insertion | Adds an element to the input stack. |
| `dequeue()` | O(n) worst case; O(1) amortized | O(1) auxiliary | Transfers elements between stacks when necessary and removes the front element. |
| `peek()` in queue | O(n) worst case; O(1) amortized | O(1) auxiliary | Retrieves the front element, transferring elements when necessary. |
| `isBalanced(String expr)` | O(n) | O(n) | Scans the expression and uses a stack to match opening and closing brackets. |

**Real-world application:** Stacks support undo history, function-call management, and expression parsing, while queues are used for request processing, background jobs, and task scheduling in backend systems.

### Part 3: Arrays and Strings

Let `n` represent the array length or string length.

| Method | Time Complexity | Extra Space | Explanation |
|---|---|---|---|
| `rotateRight(int[] a, int k)` | O(n) | O(1) | Rotates an array in place using three reversals. |
| `reverse(int[] a, int left, int right)` | O(n) | O(1) | Reverses a section of an array using two pointers. |
| `isAnagram(String a, String b)` | O(n) | O(1) | Compares character frequencies using a fixed-size character-count array. |
| `twoSumSorted(int[] a, int target)` | O(n) | O(1) | Uses two pointers to find a pair in a sorted array. |

**Real-world application:** Array and string algorithms are useful for processing user input, validating text, analyzing ordered data, and searching records efficiently in backend applications.

### Part 4: LRU Cache

Let `c` represent the cache capacity.

| Method | Time Complexity | Extra Space | Explanation |
|---|---|---|---|
| `LRUCache(int capacity)` | O(1) | O(1) initially | Creates the HashMap and two sentinel nodes. |
| `get(int key)` | O(1) average | O(1) auxiliary | Looks up an entry in the HashMap and moves it to the front of the list. |
| `put(int key, int value)` | O(1) average | O(1) auxiliary per operation | Inserts or updates an entry and evicts the least recently used entry when necessary. |
| `addToFront(Node node)` | O(1) | O(1) | Inserts a node immediately after the head. |
| `remove(Node node)` | O(1) | O(1) | Removes a node by updating its neighboring links. |
| `moveToFront(Node node)` | O(1) | O(1) | Moves an existing node to the most recently used position. |
| `removeLast()` | O(1) | O(1) | Removes the least recently used node from the tail. |

**Overall cache space complexity:** O(c), because the HashMap and doubly linked list store up to `c` entries.

**Real-world application:** LRU caches are used in backend systems to retain frequently accessed data, such as database query results, API responses, and frequently requested application objects, reducing repeated computation and data retrieval.

## 3. Complexity Analysis Notes

- **O(1):** Constant time; the operation does not grow with the input size.
- **O(n):** Linear time; the work grows proportionally to the input size.
- **O(c):** Space proportional to the cache capacity.
- **Average-case complexity:** HashMap operations are generally O(1) on average, although their worst-case behavior can be slower.
- **Amortized complexity:** An operation may occasionally take O(n), but its average cost across a sequence of operations is O(1).

For the queue implemented using two stacks, each element is transferred at most once from the input stack to the output stack. This makes enqueue and dequeue O(1) amortized, even though an individual dequeue can take O(n).

For the anagram method, the character-count array has a fixed size based on Java's UTF-16 `char` range, so its auxiliary space is O(1) under that fixed-alphabet assumption.

## 4. Conclusion

This project demonstrates how choosing suitable data structures and algorithms improves performance and memory efficiency. Understanding time and space complexity helps developers build scalable backend systems, including caching services, request queues, text-processing utilities, and systems that manage ordered data.