package search_in_array;

public class DeadLock {

    public static void main(String args[]) {
        A a = new A();
        B b = new B();
        Thread t1 = new Thread(()->{a.foo(b);});
        Thread t2 = new Thread(()->{b.foo(a);});

        t1.start();
        t2.start();
    }
}

class A {

    synchronized void foo(B b) {
        try {Thread.sleep(1000);}catch(Exception e) {}
        b.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last");
    }
}

class B {

    synchronized void foo(A a) {
        try {Thread.sleep(1000);}catch(Exception e) {}
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside B.last");
    }
}

