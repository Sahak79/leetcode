package arrays;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MaxPointsOnALine {

    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]
                {{0,0},{1,1},{1,-1}}));
    }

    public static int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int max = 0;
        Map<Point, Integer> pointMap = new HashMap<>(); // for duplicate points
        Map<Point, Integer> parallelLinesMap = new HashMap<>();
        Map<Point, Integer> zeroBaseLineMap = new HashMap<>(); // for points appearing in lines crossing zero
        int zero = 0;
        int parallelMax = 0;
        int x0 = 0;
        int y0 = 0;
        for (int[] p : points) {
            int x = p[0];
            int y = p[1];
            x0 = x == 0 ? x0 + 1 : x0;
            y0 = y == 0 ? y0 + 1 : y0;
            if (x == 0 && y == 0) {
                zero++;
                continue;
            }
            Point point1 = new Point(x, y);
            Point point;
            if (x == 0 || y == 0) {
                point = new Point(x, y);
            } else {
                BigInteger bx = BigInteger.valueOf(x);
                BigInteger by = BigInteger.valueOf(y);
                BigInteger gcd = bx.gcd(by);
                x = bx.divide(gcd).intValue();
                y = by.divide(gcd).intValue();
                if (zeroBaseLineMap.containsKey(new Point(-x, -y))) {
                    x = -x;
                    y = -y;
                }
                point = new Point(x, y);
            }
            // find max points appearing in line crossing zero base
            max = processPointInMap(zeroBaseLineMap, point, max);

            // put duplicate points into map with appearance count
            if (pointMap.containsKey(point1)) {
                pointMap.put(point1, pointMap.get(point1) + 1);
            } else {
                pointMap.put(point1, 1);
            }

            // find points in lines parallel with x or y
            Point point2 = new Point(point1.x, 0);
            parallelMax = processPointInMap(parallelLinesMap, point2, parallelMax);
            Point point3 = new Point(0, point1.y);
            parallelMax = processPointInMap(parallelLinesMap, point3, parallelMax);
        }
        if (x0 == points.length || y0 == points.length) {
            return points.length;
        }
        max = zero > 0 ? max + zero : max;
        max = x0 > max ? x0 : max;
        max = y0 > max ? y0 : max;
        max = parallelMax > max ? parallelMax : max;

        Map<Line, PointSet<Point>> lineMap = new HashMap<>(); // lines map with points set
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (!(x1 == x2 && y1 == y2) && (x1 == x2 || y1 == y2)) {
                    continue;
                }
                // b
                int[] i1i2 = getDividers(y1 * x2 - x1 * y2, x2 - x1);
                int i1 = i1i2[0];
                int i2 = i1i2[1];
                if (i1 == 0) {
                    continue;
                }

                // k
                int[] k1k2 = getDividers(y2 - y1, x2 - x1);
                int k1 = k1k2[0];
                int k2 = k1k2[1];

                Line line = new Line(i1, i2, k1, k2);
                Point point1 = new Point(x1, y1);
                Point point2 = new Point(x2, y2);
                PointSet<Point> pointSet = addLineToMap(lineMap, pointMap, point1, point2, line);
                if (pointSet.pointsCount > max) {
                    max = pointSet.pointsCount;
                }
            }
        }
        return max;
    }

    public static int[] getDividers(int i1, int i2) {
        BigInteger o1 = BigInteger.valueOf(i1);
        BigInteger o2 = BigInteger.valueOf(i2);
        BigInteger gcd1 = o1.gcd(o2);
        if (gcd1.intValue() != 0) {
            i1 = o1.divide(gcd1).intValue();
            i2 = o2.divide(gcd1).intValue();
        } else {
            i1 = o1.intValue();
            i2 = o2.intValue();
        }
        if (i1 < 0) {
            if (i2 < 0) {
                i1 = Math.abs(i1);
                i2 = Math.abs(i2);
            } else {
                i1 = - Math.abs(i1);
                i2 = Math.abs(i2);
            }
        } else {
            if (i2 < 0) {
                i1 = - Math.abs(i1);
                i2 = Math.abs(i2);
            } else {
                i1 = Math.abs(i1);
                i2 = Math.abs(i2);
            }
        }
        return new int[]{i1, i2};
    }

    public static int processPointInMap(Map<Point, Integer> map, Point point,  int max) {
        if (map.containsKey(point)) {
            map.put(point, map.get(point) + 1);
            if (max < map.get(point)) {
                return map.get(point);
            }
        } else {
            map.put(point, 1);
            if (max < 1) {
                return 1;
            }
        }
        return max;
    }

    private static PointSet<Point> addLineToMap(Map<Line, PointSet<Point>> lineMap,
                                      Map<Point, Integer> pointMap,
                                     Point point1, Point point2, Line line) {
        PointSet<Point> pointSet;
        if (lineMap.containsKey(line)) {
            pointSet = lineMap.get(line);
            Set<Point> set = pointSet.set;
            if (!set.contains(point1)) {
                int point1Count = pointMap.get(point1);
                pointSet.pointsCount += point1Count;
                set.add(point1);
            }
            if (!set.contains(point2)) {
                int point2Count = pointMap.get(point2);
                pointSet.pointsCount += point2Count;
                set.add(point2);
            }
        } else {
            pointSet = new PointSet<>();
            if(pointSet.set.add(point1)) {
                pointSet.pointsCount += pointMap.get(point1);
            }
            if(pointSet.set.add(point2)) {
                pointSet.pointsCount += pointMap.get(point2);
            }
            lineMap.put(line, pointSet);
        }
        return pointSet;
    }

    static class PointSet<E extends Point>{
        Set<E> set = new HashSet<>();
        int pointsCount = 0;
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

    static class Line{
        int i1;
        int i2;
        int k1;
        int k2;

        public Line(int i1, int i2, int k1, int k2) {
            this.i1 = i1;
            this.i2 = i2;
            this.k1 = k1;
            this.k2 = k2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Line)) return false;
            Line line = (Line) o;
            return i1 == line.i1 &&
                    i2 == line.i2 &&
                    k1 == line.k1 &&
                    k2 == line.k2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i1, i2, k1, k2);
        }
    }
}
