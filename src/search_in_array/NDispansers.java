package search_in_array;

import java.util.ArrayDeque;
import java.util.Queue;

public class NDispansers {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 6, 2}, 2, 11, 3));
    }

    public static int solution(int[] A, int X, int Y, int Z) {
        ArrayDeque<Car> queue = new ArrayDeque<>();
        for (int i : A) {
            Car car = new Car(i);
            queue.addLast(car);
        }
        Car car1 = queue.pollFirst();
        Car car2 = queue.pollFirst();
        Car car3 = queue.pollFirst();
        int index = 0;
        while (true) {
            boolean anyCarFilled = false;
            if (A.length > 2 && car1 != null && car2 != null && car3 != null
                    && car1.petrolNeeded == 0 && car2.petrolNeeded == 0 && car3.petrolNeeded == 0) {
                break;
            }
            if (A.length == 2 && car1 != null && car2 != null
                    && car1.petrolNeeded == 0 && car2.petrolNeeded == 0) {
                break;
            }
            if (A.length == 1 && car1 != null && car1.petrolNeeded == 0) {
                break;
            }

            if (car1 != null && car1.petrolNeeded != 0) {
                if (car1.petrolNeeded <= X) {
                    if (car1.fillTank()) {
                        queue.addLast(car1);
                        car1 = queue.pollFirst();
                    } else {
                        X--;
                        anyCarFilled = true;
                    }
                } else {
                    car1.beenInFirst = true;
                    if (beenInAllDispansers(car1)) {
                        return -1;
                    }
                    Car carTmp = car1;
                    car1 = getCarForFirstDispanser(queue);
                    queue.addFirst(carTmp);
                }
            }
            if (car2 != null && car2.petrolNeeded != 0) {
                if (car2.petrolNeeded <= Y) {
                    if (car2.fillTank()) {
                        queue.addLast(car2);
                        car2 = queue.pollFirst();
                    } else {
                        Y--;
                        anyCarFilled = true;
                    }
                } else {
                    car2.beenInSecond = true;
                    if (beenInAllDispansers(car2)) {
                        return -1;
                    }
                    Car carTmp = car2;
                    car2 = getCarForSecondDispanser(queue);
                    queue.addFirst(carTmp);
                }
            }
            if (car3 != null && car3.petrolNeeded != 0) {
                if (car3.petrolNeeded <= Z) {
                    if (car3.fillTank()) {
                        queue.addLast(car3);
                        car3 = queue.pollFirst();
                    } else {
                        Z--;
                        anyCarFilled = true;
                    }
                } else {
                    car3.beenInThird = true;
                    if (beenInAllDispansers(car3)) {
                        return -1;
                    }
                    Car carTmp = car3;
                    car3 = getCarForThirdDispanser(queue);
                    queue.addFirst(carTmp);
                }
            }
            if (anyCarFilled) {
                index++;
            }
            /*if (car1 != null && car2 == null && car3 == null) {
                return -1;
            }*/
        }
        return index;
    }

    public static Car processCar(ArrayDeque<Car> queue, Car car, Integer dispanser, int index) {
        if (car.petrolNeeded != 0) {
            if (car.petrolNeeded <= dispanser) {
                if (car.fillTank()) {
                    queue.addLast(car);
                    car = queue.pollFirst();
                } else {
                    dispanser--;
                }
            } else {
                car.beenInFirst = true;
                if (beenInAllDispansers(car)) {
                    return null;
                }
                Car carTmp = car;
                car = getCarForFirstDispanser(queue);
                queue.addFirst(carTmp);
            }
        }
        return car;
    }

    public static Car getCarForFirstDispanser(Queue<Car> queue) {
        Car car = null;
        for (Car c : queue) {
            if (!c.beenInFirst) {
                car = c;
            }
        }
        queue.remove(car);
        return car;
    }

    public static Car getCarForSecondDispanser(Queue<Car> queue) {
        Car car = null;
        for (Car c : queue) {
            if (!c.beenInSecond) {
                car = c;
            }
        }
        queue.remove(car);
        return car;
    }

    public static Car getCarForThirdDispanser(Queue<Car> queue) {
        Car car = null;
        for (Car c : queue) {
            if (!c.beenInThird) {
                car = c;
            }
        }
        queue.remove(car);
        return car;
    }

    public static boolean beenInAllDispansers(Car car) {
        return car.beenInThird && car.beenInFirst && car.beenInSecond;
    }

    static class Car {
        int petrolNeeded = 0;
        boolean beenInFirst;
        boolean beenInSecond;
        boolean beenInThird;

        public Car(int petrolNeeded) {
            this.petrolNeeded = petrolNeeded;
        }

        public boolean fillTank() {
            return --petrolNeeded == 0;
        }
    }
}
