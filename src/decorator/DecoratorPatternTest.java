package decorator;

import java.util.Arrays;
import java.util.Vector;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Car car1 = new SportsCar(new BasicCar());
        car1.assemble();
        System.out.println("");
        Car car2 = new LuxuryCar(new SportsCar(new BasicCar()));
        car2.assemble();

        Vector<String> strings = new Vector<String>(10);



    }
}

class GenericArrayTest1<T>{

    private Class<T> tClass;

    public T[] returnArray(){
        return (T[])java.lang.reflect.Array.newInstance(tClass, 10);
    }

}
