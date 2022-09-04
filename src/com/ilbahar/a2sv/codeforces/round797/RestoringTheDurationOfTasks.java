package com.ilbahar.a2sv.codeforces.round797;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author filbahar
 * @created 7.06.2022
 */
public class RestoringTheDurationOfTasks {

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int numberOfTest = sc.nextInt();
        for (int i = 0; i < numberOfTest; i++) {
            int n = sc.nextInt();
            int[] taskGivenTimes = new int[n];
            String numbers = sc.nextLine();
            String[] str = numbers.split(" ");
            for(int j = 0 ; j < str.length ; j++){
                taskGivenTimes[j]=Integer.parseInt(str[j]);
            }
            int[] completeTime = new int[n];
            String numbers2 = sc.nextLine();
            String[] str2 = numbers2.split(" ");
            for(int j = 0 ; j < str2.length ; j++){
                completeTime[j]=Integer.parseInt(str2[j]);
            }
            String[] result = findDurations(taskGivenTimes, completeTime, n);
            String joined = String.join(" ", result);
            out.println(joined);
        }
        out.close();
    }

    public static String[] findDurations(int[] taskGivenTimes, int[] completeTimes, int n) {
        String[] result = new String[n];
        result[0] = String.valueOf(completeTimes[0] - taskGivenTimes[0]);

        if (n > 1) {
            for (int i = 1; i < n; i++) {
                result[i] = String.valueOf(completeTimes[i] - (Math.max(completeTimes[i - 1], taskGivenTimes[i])));
            }
        }
        return result;
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
