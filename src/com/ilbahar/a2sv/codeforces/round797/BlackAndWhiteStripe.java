package com.ilbahar.a2sv.codeforces.round797;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author filbahar
 * @created 7.06.2022
 */
public class BlackAndWhiteStripe {

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int numberOfTest = sc.nextInt();
        for (int i = 0; i < numberOfTest; i++) {
            int[] taskGivenTimes = new int[2];
            String numbers = sc.nextLine();
            String[] str = numbers.split(" ");
            for(int j = 0 ; j < str.length ; j++){
                taskGivenTimes[j]=Integer.parseInt(str[j]);
            }
            int n = taskGivenTimes[0];
            int k = taskGivenTimes[1];
            String cells = sc.nextLine();
            out.println(solve(n, k, cells));
        }
        out.close();
    }

    public static int solve(int n, int k, String cells) {
        int numberOfBlacksInInterval = 0;
        int startIndexOfInterval = 0;
        int endIndexOfInterval = k - 1;

        char[] cellsArray = cells.toCharArray();
        for (int i = 0; i <= n - k; i++) {
            int localBlacks = 0;
            for (int j = i; j < i + k; j++) {
                if (cellsArray[j] == 'B') localBlacks++;
            }
            if (localBlacks > numberOfBlacksInInterval) {
                numberOfBlacksInInterval = localBlacks;
                startIndexOfInterval = i;
                endIndexOfInterval = i + k - 1;
            }
        }
        return k - numberOfBlacksInInterval;
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
