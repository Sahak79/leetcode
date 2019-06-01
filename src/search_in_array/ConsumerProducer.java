package search_in_array;

class ConsumerProducer1 {

    boolean valueSet = false;

    public static void main(String[] args) {
        ConsumerProducer1 consumerProducer1 = new ConsumerProducer1();
        Consumer1 consumer1 = new Consumer1(consumerProducer1);
        Producer1 producer1 = new Producer1(consumerProducer1);
    }

    synchronized void consume(){
        if (valueSet) {
            try {
                this.wait();
            } catch (InterruptedException e) {}
        }
        System.out.println("consume");
        valueSet = true;
        notify();
    }

    synchronized void produce() {
        if (!valueSet) {
            try {
                this.wait();
            } catch (InterruptedException e) {}
        }
        System.out.println("produce");
        valueSet = false;
        notify();
    }
}

class Consumer1 implements Runnable {

    ConsumerProducer1 consumerProducer1;

    Consumer1(ConsumerProducer1 consumerProducer1) {
        this.consumerProducer1 = consumerProducer1;
        new Thread(this, "Consumer1").start();
    }

    @Override
    public void run() {
        while (true) {
            consumerProducer1.consume();
        }
    }
}

class Producer1 implements Runnable {

    ConsumerProducer1 consumerProducer1;

    Producer1(ConsumerProducer1 consumerProducer1) {
        this.consumerProducer1 = consumerProducer1;
        new Thread(this, "Producer1").start();
    }

    @Override
    public void run() {
        while (true) {
            consumerProducer1.produce();
        }
    }
}
