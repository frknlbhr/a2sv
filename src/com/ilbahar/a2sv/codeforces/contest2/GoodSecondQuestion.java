package com.ilbahar.a2sv.codeforces.contest2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author filbahar
 * @created 5.03.2022
 */
public class GoodSecondQuestion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lengths = scanner.nextLine();
        String[] lengthsArray = lengths.split(" ");
        int n = Integer.parseInt(lengthsArray[0]);
        int m = Integer.parseInt(lengthsArray[1]);
        String studentDifs = scanner.nextLine();
        String[] str = studentDifs.split(" ");
        int[] studentMaxDifs = new int[m];
        for (int i = 0; i < m; i++) {
            studentMaxDifs[i] = Integer.parseInt(str[i]);
        }
        int[] questionDif = new int[n];
        for (int i = 0; i < n; i++) {
            questionDif[i] = scanner.nextInt();
        }
        Arrays.sort(studentMaxDifs);
        for (int q : questionDif) {
            System.out.println(isGoodSecondQuestion(q, studentMaxDifs));
        }
    }

    public static String isGoodSecondQuestion(int questionDificulty, int[] studentMaxDificulties) {
        int numberOfQuestionsStudentsCanSolve = binarySearch(studentMaxDificulties, questionDificulty);
        if (numberOfQuestionsStudentsCanSolve == studentMaxDificulties.length) return "NO";
        return numberOfQuestionsStudentsCanSolve > studentMaxDificulties.length / 2 ? "YES" : "NO";
    }

    private static int binarySearch(int[] sortedArray, int target) {
        int m = sortedArray.length;
        if (target <= sortedArray[0]) return m;
        int left = 0;
        int right = m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedArray[mid] == target) {
                return m - mid;
            } else if (mid != right && sortedArray[mid] < target && sortedArray[mid + 1] > target) {
                return m - mid - 1;
            } else if (mid != 0 && sortedArray[mid] > target && sortedArray[mid - 1] < target) {
                return m - mid;
            } else if (target < sortedArray[mid]) {
                right = mid - 1;
            } else if (target > sortedArray[mid]) {
                left = mid + 1;
            }
        }
        return 0;
    }

}
