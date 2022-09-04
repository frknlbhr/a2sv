package com.ilbahar.a2sv.codeforces.contest2;

import java.util.Scanner;

/**
 * @author filbahar
 * @created 5.03.2022
 */
public class A31vs32 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] tests = new int[t];
        for (int i = 0; i < t; i++) {
            int test = scanner.nextInt();
            tests[i] = test;
        }

        for (int k : tests) {
            if (k >= 32) {
                int dif = 32 - k;
                int mod = dif % 4;
                if (mod == 0)
                    System.out.println(32);
                else
                    System.out.println(31);
            } else
                System.out.println(31);
        }
    }

}
