package com.varteq.rest.queue;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueManager {

    private static BlockingQueue<String> queue;

    public static void init() {
        if (queue == null) {
            synchronized (QueueManager.class) {
                queue = new ArrayBlockingQueue<>(10);
            }
        } else {
            throw new IllegalStateException("Queue is already initialized");
        }
    }

    public static int getSize() {
        return queue.size();
    }

    public static boolean add(String s) {
        return queue.add(s);
    }

    public static String get() {
        return queue.peek();
    }

    public static Collection<String> getAll() {
        return Collections.unmodifiableCollection(queue);
    }

    public static String poll() {
        return queue.poll();
    }
}
