package com.ilbahar.a2sv.leetcode.sorting._973;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int[][] kClosest(int[][] points, int k) {
        List<Point> pointsWithDistance = new ArrayList<>();
        for (int[] point : points) {
            pointsWithDistance.add(new Point(point[0], point[1]));
        }
        Collections.sort(pointsWithDistance);

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pointsWithDistance.get(i).toPointArray();
        }
        return result;
    }

    class Point implements Comparable<Point> {
        public int x;
        public int y;
        public double distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        }

        public int[] toPointArray() {
            int[] pointAsArray = new int[2];
            pointAsArray[0] = this.x;
            pointAsArray[1] = this.y;
            return pointAsArray;
        }

        @Override
        public int compareTo(Point point) {
            return Double.compare(this.distance, point.distance);
        }
    }

}
