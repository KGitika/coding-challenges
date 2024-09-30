// Problem: Design a Stack With Increment Operation
// URL: https://leetcode.com/problems/design-a-stack-with-increment-operation/


import java.util.ArrayList;
import java.util.List;

// Solution 1: Using Arrays and Lazy Propagation
class CustomStackArray {

    private int[] stackArray;
    private int[] incrementArray;
    private int topIndex;

    public CustomStackArray(int maxSize) {
        stackArray = new int[maxSize];
        incrementArray = new int[maxSize];
        topIndex = -1;
    }

    public void push(int x) {
        if (topIndex < stackArray.length - 1) {
            stackArray[++topIndex] = x;
        }
    }

    public int pop() {
        if (topIndex < 0) return -1;

        int result = stackArray[topIndex] + incrementArray[topIndex];

        if (topIndex > 0) {
            incrementArray[topIndex - 1] += incrementArray[topIndex];
        }

        incrementArray[topIndex] = 0;
        topIndex--;
        return result;
    }

    public void increment(int k, int val) {
        if (topIndex >= 0) {
            int incrementIndex = Math.min(topIndex, k - 1);
            incrementArray[incrementIndex] += val;
        }
    }
    
    // Time Complexity:
    // push: O(1)
    // pop: O(1)
    // increment: O(1)
}

// Solution 2: Using List
class CustomStackList {

    List<Integer> list;
    int size;

    public CustomStackList(int maxSize) {
        list = new ArrayList<>();
        size = maxSize;
    }

    public void push(int x) {
        if (list.size() < size) {
            list.add(x);
        }
    }

    public int pop() {
        if (list.size() == 0) return -1;
        return list.remove(list.size() - 1);
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i < list.size(); i++) {
            list.set(i, list.get(i) + val);
        }
    }

    // Time Complexity:
    // push: O(1)
    // pop: O(1)
    // increment: O(min(k, size)) -> O(k)
}