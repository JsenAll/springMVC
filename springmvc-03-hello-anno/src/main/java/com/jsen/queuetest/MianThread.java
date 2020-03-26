package com.jsen.queuetest; /*
 *@author Jsen
 *@description
 */


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MianThread {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue =  new LinkedBlockingDeque<String>(20);
        ProducerThread producerThread1 = new ProducerThread(queue);
        ConsumerThread consumerThread1 = new ConsumerThread(queue);
        Thread t1 = new Thread(producerThread1);
        Thread c1 = new Thread(consumerThread1);
        t1.start();
        c1.start();
        while (true) {
            Thread.sleep(2 * 1000);
            System.out.println("队列中的数据" + queue.size());
        }
    }
}
