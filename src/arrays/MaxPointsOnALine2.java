package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MaxPointsOnALine2 {
    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]
                {{0,0},{1,1},{1,-1}}));
    }

    public static int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        Map<Point, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x1 > x2) {

                }


            }
        }

        return 0;
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
            if (!(o instanceof MaxPointsOnALine.Point)) return false;
            MaxPointsOnALine.Point point = (MaxPointsOnALine.Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
