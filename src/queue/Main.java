package queue;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{
        final BlockingQueue queue = new BlockingQueue(2);

        final int threads = 2;
        final int times = 10;

        List<Thread> threadList = new ArrayList<>(threads * 2);
        long startTime = System.currentTimeMillis();


        for (int i=0;i<threads;i++) {
            final int offset = i * times;
            Thread producer = new Thread(() -> {
               try {
                   for (int j = 0; j < times; ++j) {
                       queue.put(offset + j);
                   }
               } catch (Exception e) {
                   e.printStackTrace();
               }
            });
            threadList.add(producer);
            producer.start();
        }


        for (int i=0;i<threads;i++) {
            Thread consumer = new Thread(() -> {
                try {
                    for (int j = 0; j < times; ++j) {
                        Integer e = (Integer) queue.take();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            threadList.add(consumer);
            consumer.start();
        }

        for (Thread t : threadList) {
            t.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Total time:%.2fs", (endTime - startTime)/1e3));
    }
}
