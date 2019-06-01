package search_in_array;

import java.util.concurrent.atomic.AtomicInteger;

public class PingPong {

    boolean valueSet = false;

    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        Ping ping = new Ping(pingPong);
        Pong pong = new Pong(pingPong);
    }

    synchronized void ping(){
        try {
            if(valueSet){
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- ping");
        notify();
        valueSet = true;
    }

    synchronized void pong(){
        try {
            if(!valueSet){
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("+++ pong");
        notify();
        valueSet = false;
    }
}

class Ping implements Runnable{

    PingPong pingPong;

    Ping(PingPong pingPong){
        this.pingPong = pingPong;
        new Thread(this, "Ping").start();
    }

    @Override
    public void run() {
        while (true){
            pingPong.ping();
        }
    }
}

class Pong implements Runnable{

    PingPong pingPong;

    Pong(PingPong pingPong){
        this.pingPong = pingPong;
        new Thread(this, "Pong").start();
    }
    AtomicInteger a = new AtomicInteger(0);

    @Override
    public void run() {
        a.getAndIncrement();
        a.incrementAndGet();
        DD dd = new DD();
        while (true){
            pingPong.pong();
        }
    }
}

abstract class SS{
    SS(){
        System.out.println("SS");

    }
}

class DD extends SS{
    DD(){
        System.out.println("DD");
    }
}