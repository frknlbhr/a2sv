package com.ilbahar.a2sv.codeforces.contest;

import java.util.Scanner;

/**
 * @author filbahar
 * @created 26.02.2022
 */
public class NewYearAndHurry {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(solve(n, k));
    }

    public static int solve(int n, int k) {
        int[] totalTimeSpendForQuestions = new int[10];
        totalTimeSpendForQuestions[0] = 5;
        for (int i = 1; i < 10; i++) {
            totalTimeSpendForQuestions[i] = totalTimeSpendForQuestions[i - 1] + (5 * (i + 1));
        }

        int timeForQuestions = 240 - k;
        int left = 0;
        int right = totalTimeSpendForQuestions.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (totalTimeSpendForQuestions[mid] == timeForQuestions
                    || (totalTimeSpendForQuestions[mid] < timeForQuestions && totalTimeSpendForQuestions[mid + 1] > timeForQuestions)) {
                return Math.min(mid + 1, n);
            } else if (totalTimeSpendForQuestions[mid] < timeForQuestions) {
                left = mid + 1;
            } else if (totalTimeSpendForQuestions[mid] > timeForQuestions) {
                right = mid - 1;
            }
        }
        return 0;
    }

}
