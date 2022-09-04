package com.ilbahar.a2sv.codeforces.round129;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author filbahar
 * @created 23.05.2022
 */
public class CardTrick {

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int numberOfTest = sc.nextInt();
        for (int i = 0; i < numberOfTest; i++) {
            int n = sc.nextInt();
            int[] cards = new int[n];
            String numbers = sc.nextLine();
            String[] str = numbers.split(" ");
            for(int j = 0 ; j < str.length ; j++){
                cards[j]=Integer.parseInt(str[j]);
            }
            int m = sc.nextInt();
            int[] shuffles = new int[m];
            String numbersbob = sc.nextLine();
            String[] strbob = numbersbob.split(" ");
            for(int j = 0 ; j < strbob.length ; j++){
                shuffles[j]=Integer.parseInt(strbob[j]);
            }
            out.println(findTheTopCard(n, cards, m, shuffles));
        }
        out.close();
    }

    public static int findTheTopCard(int n, int[] cards, int m, int[] shuffles) {
        long totalShuffle = 0L;
        for (int i = 0; i < m; i++) {
            totalShuffle += shuffles[i];
        }
        long mod = totalShuffle % (long)n;
        return cards[(int)mod];
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
