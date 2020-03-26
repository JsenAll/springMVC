package com.jsen.queuetest; /*
 *@author Jsen
 *@description
 */

import java.util.concurrent.BlockingQueue;

public class ProducerThread implements Runnable {
    private BlockingQueue queue;

    public ProducerThread(BlockingQueue queue) {
        this.queue = queue;
    }

    int a = 0;

    public void run() {

        while (true) {
            try {
                queue.put(a);
                System.out.println("生产数据" + a);
                a++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
