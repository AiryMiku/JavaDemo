package queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {

    private final Object[] objects;
    private int capacity;
    private int takeIndex;
    private int putIndex;

    // The key of block
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public BlockingQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        objects = new Object[capacity];
    }

    public void put(Object e) throws InterruptedException{
        lock.lockInterruptibly();
        try {
            while (capacity == objects.length) {
                condition.await();
            }
            enqueue(e);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (capacity == 0) {
                condition.await();
            }

            Object e = dequeue();
            condition.signalAll();
            return e;
        } finally {
            lock.unlock();
        }
    }

    private void enqueue(Object e) {
        objects[putIndex] = e;

        if (++putIndex == objects.length) {
            putIndex = 0;
        }

        capacity++;
    }


    private Object dequeue() {
        Object e = objects[takeIndex];
        objects[takeIndex] = null;

        if (++takeIndex == objects.length) {
            takeIndex = 0;
        }

        capacity--;

        return e;
    }
}
