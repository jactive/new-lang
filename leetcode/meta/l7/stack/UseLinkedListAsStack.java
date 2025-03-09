package leetcode.meta.l7.stack;

import java.util.LinkedList;

public class UseLinkedListAsStack {
    public static void main(String[] args) {
        LinkedList<String> stack = new LinkedList<>();
        stack.push("a");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
