package com.rtaylor.javacourse.collections.queue;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Key Lessons:
#1 - Create a Queue from a Collection. PriorityQueue is a class that implements Queue.
#2 - Queue is stored NOT in order, but processed in order when using poll() (see #4)
#3 - offer() - Adding an element to the queue. Returns boolean - true: added.
#4 - poll() - Process an element in natural order.
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("Car", "Building", "House", "Door", "Bicycle");
        new QueueTrial().priorityQueue(list);
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
}