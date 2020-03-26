package com.jsen.queuetest; /*
 *@author Jsen
 *@description
 */

import java.util.concurrent.BlockingQueue;

public class ConsumerThread implements Runnable {
    private BlockingQueue queue;

    public ConsumerThread(BlockingQueue queue) {

        this.queue = queue;
    }

    public void run() {
        while (queue.size() == 0) System.out.println("队列为空,等待添加数据");
        while (true) {

            Object peek = queue.poll();
            int p = (Integer) peek;
            System.out.println(p);
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
