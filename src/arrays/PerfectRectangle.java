package arrays;

import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle {

    public static void main(String[] args) {
        int[][] rectangles1 = new int[][]{
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {3, 2, 4, 4},
                {1, 3, 2, 4},
                {2, 3, 3, 4}
        };
        System.out.println(isRectangleCover(rectangles1));
        int[][] rectangles2 = new int[][]{
                {1, 1, 2, 3},
                {1, 3, 2, 4},
                {3, 1, 4, 2},
                {3, 2, 4, 4}
        };
        System.out.println(isRectangleCover(rectangles2));

    }

    public static boolean isRectangleCover(int[][] rectangles) {
        int minX1 = Integer.MAX_VALUE;
        int minY1 = Integer.MAX_VALUE;
        int maxX2 = Integer.MIN_VALUE;
        int maxY2 = Integer.MIN_VALUE;
        Set<String> rectangleUnits = new HashSet<>();
        for (int[] points : rectangles) {
            int x1 = points[0];
            int y1 = points[1];
            int x2 = points[2];
            int y2 = points[3];
            if (x1 < minX1) minX1 = x1;
            if (y1 < minY1) minY1 = y1;
            if (x2 > maxX2) maxX2 = x2;
            if (y2 > maxY2) maxY2 = y2;
            boolean exist = fillAllRectangleUnits(rectangleUnits, x1, y1, x2, y2);
            if (!exist) return false;
        }
        int completeRectangleVolume = (maxX2 - minX1) * (maxY2 - minY1);
        return completeRectangleVolume == rectangleUnits.size();
    }

    private static boolean fillAllRectangleUnits(Set<String> rectangleUnits, int x1, int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                boolean exist = rectangleUnits.add(String.valueOf(i) + j + (i + 1) + (j + 1));
                if (!exist) {
                    return false;
                }
            }
        }
        return true;
    }
}
