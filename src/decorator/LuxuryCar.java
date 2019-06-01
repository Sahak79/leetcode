package decorator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LuxuryCar extends CarDecorator {

    LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void assemble(){



        super.assemble();
        System.out.print(" Adding features of Luxury Car.");
    }
}
