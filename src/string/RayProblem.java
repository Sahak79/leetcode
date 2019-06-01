package string;

import javafx.util.Pair;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class RayProblem {
    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{2, 4, 1, 6, 5, 9, 7}));
    }

    public static int maxChunksToSorted(int[] arr) {
        Stack<int[]> s = new Stack<>();
        for(int i=0; i<arr.length; i++){
            int min=arr[i];
            int max=arr[i];
            while(!s.isEmpty()){
                int[] top = s.peek();
                if(arr[i] < top[1]){
                    min=Math.min(top[0], min);
                    max=Math.max(max, top[1]);
                    s.pop();
                }else{
                    break;
                }
            }
            s.push(new int[]{min,max});
        }
        return s.size();
    }

    public static int get(Point2D[] A) {
        int result = 0;
        Set<Tuple> set = new HashSet<>();

        for (Point2D point2D : A) {
            int gcd = gcdThing(point2D.x, point2D.y);
            Tuple t = new Tuple(point2D.x / gcd, point2D.y / gcd);
            if (!set.contains(t)) {
                set.add(t);
                result++;
            }
        }
        return result;
    }

    static class Tuple {
        int x;
        int y;

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tuple)) return false;
            Tuple tuple = (Tuple) o;
            return x == tuple.x &&
                    y == tuple.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static int gcdThing(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }

    static class Point2D{
        public Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;
        public int y;
    }
}
