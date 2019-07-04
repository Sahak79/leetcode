package search_in_array;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LinesForPoints {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{3,3},{-4,-4},{-15,-15},{6,6},{-5,5},{5,-5}}));
    }

    public static int solution(int points[][]) {
        int max = 0;
        Map<Point, Integer> map = new HashMap<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            BigInteger bx = BigInteger.valueOf(x);
            BigInteger by = BigInteger.valueOf(y);
            BigInteger gcd = bx.gcd(by);
            x = bx.divide(gcd).intValue();
            y = by.divide(gcd).intValue();
            if (map.containsKey(new Point(-x, -y))) {
                x = -x;
                y = -y;
            }
            Point point1 = new Point(x, y);
            if (map.containsKey(point1)) {
                map.put(point1, map.get(point1) + 1);
                if (max < map.get(point1)) {
                    max = map.get(point1);
                }
            } else {
                map.put(point1, 1);
                if (max < 1) {
                    max = 1;
                }
            }
        }
        return max;
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
