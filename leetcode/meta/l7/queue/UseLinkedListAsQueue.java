package leetcode.meta.l7.queue;

import java.util.LinkedList;
import java.util.Queue;

public class UseLinkedListAsQueue {
    public static void main(String[] args) {
        // GoOver
        Queue<String> queue = new LinkedList<>();
        queue.add("a");
        queue.offer("b");
        System.out.println(queue.remove());
        System.out.println(queue.poll());
    }
}
