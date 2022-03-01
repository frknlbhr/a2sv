package com.ilbahar.a2sv.leetcode.dfs._733;

import java.util.Arrays;

/**
 * @author filbahar
 * @created 1.03.2022
 */
public class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int startColor = image[sr][sc];
        if (startColor == newColor) {
            return image;
        }
        dfs(image, sr, sc, startColor, newColor, directions);
        return image;

    }

    private void dfs(int[][] image, int sr, int sc, int startColor, int newColor, int[][] directions) {
        image[sr][sc] = newColor;
        for (int[] direction : directions) {
            int newRow = sr + direction[0];
            int newColumn = sc + direction[1];
            if (checkInBound(newRow, newColumn, image) && image[newRow][newColumn] == startColor) {
                dfs(image, newRow, newColumn, startColor, newColor, directions);
            }
        }
    }

    private boolean checkInBound(int row, int column, int[][] image) {
        int n = image.length;
        int m = image[0].length;
        return row >= 0 && row < n && column >= 0 && column < m;
    }

}
