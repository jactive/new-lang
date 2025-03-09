package leetcode.meta.l7.stack;

import java.util.LinkedList;

class QueueUsingStacks {
    private LinkedList<Integer> pushStack; // Used for enqueue operations
    private LinkedList<Integer> popStack;  // Used for dequeue operations

    public QueueUsingStacks() {
        pushStack = new LinkedList<>();
        popStack = new LinkedList<>();
    }

    // Enqueue operation
    public void enqueue(int x) {
        pushStack.push(x);
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    // Peek operation (Check the front element)
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // Output: 1
        queue.enqueue(4);
        System.out.println(queue.dequeue()); // Output: 2
        System.out.println(queue.peek());    // Output: 3
        System.out.println(queue.dequeue()); // Output: 3
        System.out.println(queue.dequeue()); // Output: 4
    }
}