package search_in_array;

public class TickTack2 {

    private boolean switcher = true;

    synchronized void tick() {
        if (!switcher) {
            try {wait();} catch (InterruptedException ignored) {}
        }
        System.out.println("Tick");
        switcher = false;
        notify();
    }

    synchronized void tack() {
        if (switcher) {
            try {wait();} catch (InterruptedException ignored) {}
        }
        System.out.println("Tack");
        switcher = true;
        notify();
    }

    public static void main(String[] args) {
        TickTack2 tickTack2 = new TickTack2();
        new Thread(new Tick2(tickTack2)).start();
        new Thread(new Tack2(tickTack2)).start();
    }

}

class Tick2 implements Runnable {

    private TickTack2 tickTack2;

    Tick2(TickTack2 tickTack2) {
        this.tickTack2 = tickTack2;
    }

    @Override
    public void run() {
        while (true) {
            tickTack2.tick();
        }
    }
}

class Tack2 implements Runnable {

    private TickTack2 tickTack2;

    Tack2(TickTack2 tickTack2) {
        this.tickTack2 = tickTack2;
    }

    @Override
    public void run() {
        while (true) {
            tickTack2.tack();
        }
    }
}