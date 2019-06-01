package search_in_array;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.*;
import java.util.concurrent.Semaphore;

public class ProducerConsumer {

    boolean valueSet = false;

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        new Producer(producerConsumer);
        new Consumer(producerConsumer);
    }

    public synchronized void produce() {
        while (true) {
            if (!valueSet) {
                System.out.println("Produce");
                try {
                    wait();
                } catch (InterruptedException ignored) {
                }
            }
            notify();
            valueSet = false;
        }
    }
    public synchronized void consume() {
        while (true) {
            if (valueSet) {
                System.out.println("Consume");
                try {
                    wait();
                } catch (InterruptedException ignored) {
                }
            }
            notify();
            valueSet = true;
        }
    }
}

class Producer implements Runnable {

    ProducerConsumer producerConsumer;

    Producer(ProducerConsumer producerConsumer) {
        this.producerConsumer = producerConsumer;
        new Thread(this).start();
    }

    @Override
    public void run() {
        producerConsumer.produce();
    }
}

class Consumer implements Runnable {

    ProducerConsumer producerConsumer;

    Consumer(ProducerConsumer producerConsumer) {
        this.producerConsumer = producerConsumer;
        new Thread(this).start();
    }

    @Override
    public void run() {
        producerConsumer.consume();
    }
}
