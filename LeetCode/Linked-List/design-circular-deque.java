// Problem: Design Circular Deque
// URL: https://leetcode.com/problems/design-circular-deque/

//Brute Force Approach-
    // Time Complexity: O(1)
    // Space Complexity: O(k)

class Node {

    public int val;
    public Node next;
    public Node prev;

    public Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyCircularDeque {

    Node head;
    Node rear;
    int size;
    int capacity;

    public MyCircularDeque(int k) {
        size = 0;
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (head == null) {
            // first element in list
            head = new Node(value, null, null);
            rear = head;
        } else {
            // add new head
            Node newHead = new Node(value, head, null);
            head.prev = newHead;
            head = newHead;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (head == null) {
            // first element in list
            head = new Node(value, null, null);
            rear = head;
        } else {
            // add new element to end
            rear.next = new Node(value, null, rear);
            rear = rear.next;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        if (size == 1) {
            head = null;
            rear = null;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (size == 1) {
            head = null;
            rear = null;
        } else {
            // update rear to the previous node
            rear = rear.prev;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return head.val;
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return rear.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}




// Approach 2: Fixed Array with Circular Ordering
    // Time complexity: O(1);
    // Space Complexity: O(k);

class MyCircularDeque {

    int[] array;
    int front;
    int rear;
    int size;
    int capacity;

    public MyCircularDeque(int k) {
        array = new int[k];
        size = 0;
        capacity = k;
        front = 0;
        rear = k - 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        array[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        array[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return array[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return array[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}