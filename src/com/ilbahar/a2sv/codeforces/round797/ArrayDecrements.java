package com.ilbahar.a2sv.codeforces.round797;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author filbahar
 * @created 7.06.2022
 */
public class ArrayDecrements {

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int numberOfTest = sc.nextInt();
        for (int i = 0; i < numberOfTest; i++) {
            int n = sc.nextInt();
            int[] array1 = new int[n];
            String numbers = sc.nextLine();
            String[] str = numbers.split(" ");
            for(int j = 0 ; j < str.length ; j++){
                array1[j]=Integer.parseInt(str[j]);
            }
            int[] array2 = new int[n];
            String numbers2 = sc.nextLine();
            String[] str2 = numbers2.split(" ");
            for(int j = 0 ; j < str2.length ; j++){
                array2[j]=Integer.parseInt(str2[j]);
            }
            out.println(canArrayDecrement(array1, array2, n));
        }
        out.close();
    }

    public static String canArrayDecrement(int[] array1, int[] array2, int n) {
        int maxDiffForZero = 0;
        for (int i = 0; i < n; i++) {
            if (array2[i] == 0) {
                maxDiffForZero = Math.max(array1[i] - array2[i], maxDiffForZero);
            }
            int localDiff = array1[i] - array2[i];
            if (localDiff < 0) return "NO";
        }
        Set<Integer> diffSet = new HashSet<>();
        for (int j = 0; j < n; j++) {
            if (array2[j] != 0) {
                diffSet.add(array1[j] - array2[j]);
            }
        }
        if (diffSet.size() > 1) return "NO";
        if (diffSet.size() > 0) {
            if ((int)diffSet.toArray()[0] < maxDiffForZero) return "NO";
        }
        return "YES";
    }













    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
