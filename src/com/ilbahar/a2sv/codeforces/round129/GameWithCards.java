package com.ilbahar.a2sv.codeforces.round129;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author filbahar
 * @created 23.05.2022
 */
public class GameWithCards {

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int numberOfTest = sc.nextInt();
        for (int i = 0; i < numberOfTest; i++) {
            int n = sc.nextInt();
            int[] alice = new int[n];
            String numbers = sc.nextLine();
            String[] str = numbers.split(" ");
            for(int j = 0 ; j < str.length ; j++){
                alice[j]=Integer.parseInt(str[j]);
            }
            int m = sc.nextInt();
            int[] bob = new int[m];
            String numbersbob = sc.nextLine();
            String[] strbob = numbersbob.split(" ");
            for(int j = 0 ; j < strbob.length ; j++){
                bob[j]=Integer.parseInt(strbob[j]);
            }
            out.println(findWinner(n, alice, m, bob, true));
            out.println(findWinner(n, alice, m, bob, false));
        }
        out.close();
    }

    public static String findWinner(int n, int[] alice, int m, int[] bob, boolean aliceFirst) {
        Arrays.sort(alice);
        Arrays.sort(bob);
        int maxOfAlice = alice[n - 1];
        int maxOfBob = bob[m - 1];
        if (maxOfAlice > maxOfBob) return "Alice";
        else if (maxOfBob > maxOfAlice) return "Bob";
        else {
            return aliceFirst ? "Alice" : "Bob";
        }
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
