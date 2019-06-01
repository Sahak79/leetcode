package search_in_array;

public class TickTack {

    private boolean valueSet = false;

    public static void main(String[] args) {
        TickTack tickTack = new TickTack();
        new Tick(tickTack);
        new Tack(tickTack);
    }

    synchronized void tick(){
        if(valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Tick");
        valueSet = true;
        notify();
    }

    synchronized void tack(){
        if(!valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Tack");
        valueSet = false;
        notify();
    }

}

class Tick implements Runnable{

    TickTack tickTack;

    Tick(TickTack tickTack){
        this.tickTack = tickTack;
        new Thread(this, "Tick").start();
    }

    @Override
    public void run() {
        while (true){
            tickTack.tick();
        }
    }
}

class Tack implements Runnable{

    TickTack tickTack;

    Tack(TickTack tickTack){
        this.tickTack = tickTack;
        new Thread(this, "Tack").start();
    }

    @Override
    public void run() {
        while (true){
            tickTack.tack();
        }
    }
}