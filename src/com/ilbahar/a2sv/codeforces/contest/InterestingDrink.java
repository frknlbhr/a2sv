package com.ilbahar.a2sv.codeforces.contest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author filbahar
 * @created 26.02.2022
 */
public class InterestingDrink {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            int price = scanner.nextInt();
            prices[i] = price;
        }
        int numberOfDays = scanner.nextInt();
        int[] money = new int[numberOfDays];
        for (int i = 0; i < numberOfDays; i++) {
            int m = scanner.nextInt();
            money[i] = m;
        }
        int[] result = solve(prices, money);
        for (int r : result) {
            System.out.println(r);
        }
    }

    public static int[] solve(int[] prices, int[] money) {
        Arrays.sort(prices);
        int[] result = new int[money.length];
        for (int i = 0; i < money.length; i++) {
            result[i] = search(prices, money[i]);
        }
        return result;
    }

    public static int search(int[] prices, int money) {
        int left = 0;
        int right = prices.length - 1;
        if (money > prices[right]) {
            return right + 1;
        }
        if (prices.length == 1 && money < prices[0]) {
            return 0;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (prices[mid] == money || (money < prices[mid+1] && money > prices[mid])) {
                return mid + 1;
            } else if (prices[mid] < money) {
                left = mid + 1;
            } else if (prices[mid] > money) {
                right = mid - 1;
            }
        }
        return 0;
    }

}
