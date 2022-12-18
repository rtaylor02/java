package com.rtaylor.javacourse.collection.queue;

import java.util.*;

/*
Key Lessons:
#1 - Create a Queue from a Collection. PriorityQueue is a class that implements Queue.
#2 - PriorityQueue elements are stored NOT in order, but processed in  natural order when using poll() (see #4)
#3 - offer() - Adding an element to the queue. Returns boolean - true: added.
#4 - poll() - Process an element in natural order.
#5 - Create a Comparator to allow customised priority processing order. In this case, using the String's length
     as the criterion.
#5a - Order is ascending, i.e. lowest to highest length.
#5b - Order is descending, i.e. highest to lowest length.
#6 - Use the StringLengthComparator in processing the PriorityQueue.
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("Car", "Building", "House", "Door", "Bicycle");
//        new QueueTrial().priorityQueue(list);
        new QueueTrial().priorityQueueWithComparator(list);
    }
}

class QueueTrial {
    public void priorityQueue(List<String> list) {
        Queue<String> priorityQueue = new PriorityQueue<>(list); // #1
        System.out.println(priorityQueue); // #2

        priorityQueue.offer("Laptop"); // #3
        priorityQueue.offer("Apple"); // #3
        System.out.println(priorityQueue);

        Iterator i = priorityQueue.iterator();
        while(i.hasNext()) {
            System.out.println(priorityQueue.poll()); // #4
            System.out.println(priorityQueue);
        }
    }

    public void priorityQueueWithComparator(List<String> list) {
        Queue<String> priorityQueue = new PriorityQueue<>(new StringLengthComparator()); // #6
        priorityQueue.addAll(list);
        System.out.println(priorityQueue);

        priorityQueue.offer("Laptop");
        priorityQueue.offer("Apple");
        System.out.println(priorityQueue);

        Iterator i = priorityQueue.iterator();
        while(i.hasNext()) {
            System.out.println(priorityQueue.poll());
            System.out.println(priorityQueue);
        }
    }
}

class StringLengthComparator implements Comparator<String> { // #5
    @Override
    public int compare(String s1, String s2) {
//        return Integer.compare(s1.length(), s2.length()); // #5a
        return Integer.compare(s2.length(), s1.length()); // #5b
    }
}