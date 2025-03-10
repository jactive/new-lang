package leetcode.meta.l7.exercise;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Heap Sort: PriorityQueue is the underlying data structure for heap sort.
Dijkstra's Algorithm: Used for finding the shortest paths in a graph.
Event Scheduling: Managing events based on their occurrence time.
Task Scheduling: Prioritizing tasks based on their importance.
Finding Kth Largest/Smallest Element: Efficiently finding the kth largest or smallest element in a stream of data.
 */
public class PriorityQueueExamples {
    public static void main(String[] args) {
        /**
         A PriorityQueue is a data structure
         that maintains elements in a specific order based on their priority.

         Unlike a regular queue (FIFO), elements are retrieved
         based on their natural ordering or a custom ordering defined by a Comparator.

         Internally, PriorityQueue is typically implemented using a min-heap.
         This means the smallest element (or the element with the highest priority) is always at the root.
         */
        // Min-heap (natural ordering)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(15);
        System.out.println("Min-heap peek: " + minHeap.peek()); // Output: 5

        // Max-heap (custom comparator)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(15);
        System.out.println("Max-heap peek: " + maxHeap.peek()); // Output: 15

        // PriorityQueue of custom objects
        PriorityQueue<Person> personQueue = new PriorityQueue<>();
        personQueue.add(new Person("Alice", 30));
        personQueue.add(new Person("Bob", 25));
        personQueue.add(new Person("Charlie", 35));
        System.out.println("Person queue peek: " + personQueue.peek().name); //Output: Bob


        PriorityQueue<String> stringLengthQueue = new PriorityQueue<>((first, second) -> first.length() - second.length());

        stringLengthQueue.offer("apple");
        stringLengthQueue.offer("banana");
        stringLengthQueue.offer("cat");
        stringLengthQueue.offer("dog");
        stringLengthQueue.offer("elephant");

        System.out.println("Strings sorted by length (inline):");
        while (!stringLengthQueue.isEmpty()) {
            System.out.println(stringLengthQueue.poll());
        }
    }

    static class Person implements Comparable<Person> {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person other) {
            return this.age - other.age; // Compare by age
        }
    }
}
