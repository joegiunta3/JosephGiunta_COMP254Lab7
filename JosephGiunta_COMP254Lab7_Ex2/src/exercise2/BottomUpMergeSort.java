package exercise2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class BottomUpMergeSort {

    public static <E extends Comparable<E>> Queue<E> mergeSort(Queue<E> collection) {
        if (collection == null || collection.size() <= 1) {
            return collection;
        }

        Queue<Queue<E>> queueOfQueues = new LinkedList<>();

        while (!collection.isEmpty()) {
            Queue<E> singleItemQueue = new LinkedList<>();
            singleItemQueue.add(collection.poll());
            queueOfQueues.add(singleItemQueue);
        }

        while (queueOfQueues.size() > 1) {
            Queue<E> q1 = queueOfQueues.poll();
            Queue<E> q2 = queueOfQueues.poll();
            
            Queue<E> merged = merge(q1, q2);
            queueOfQueues.add(merged);
        }

        return queueOfQueues.poll();
    }

    private static <E extends Comparable<E>> Queue<E> merge(Queue<E> q1, Queue<E> q2) {
        Queue<E> merged = new LinkedList<>();
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek().compareTo(q2.peek()) <= 0) {
                merged.add(q1.poll());
            } else {
                merged.add(q2.poll());
            }
        }
        while (!q1.isEmpty()) {
            merged.add(q1.poll());
        }
        while (!q2.isEmpty()) {
            merged.add(q2.poll());
        }
        return merged;
    }

    public static void main(String[] args) {
        System.out.println("Bottom-Up Merge Sort");
        
        Queue<Integer> numbers = new LinkedList<>(Arrays.asList(15, 3, 9, 8, 2, 10, 11, 4, 1, 7, 5, 14, 12, 6, 13));
        
        System.out.println("Original un-sorted queue: " + numbers);
        
        Queue<Integer> sortedNumbers = mergeSort(numbers);
        
        System.out.println("Sorted queue: " + sortedNumbers);
    }
}
