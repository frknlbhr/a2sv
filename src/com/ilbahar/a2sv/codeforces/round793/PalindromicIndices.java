package com.ilbahar.a2sv.codeforces.round793;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author filbahar
 * @created 22.05.2022
 */
public class PalindromicIndices {

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int numberOfTest = sc.nextInt();
        for (int i = 0; i < numberOfTest; i++) {
            int n = sc.nextInt();
            String s = sc.nextLine();
            out.println(countPalindromicIndices(s, n));
        }
        out.close();
    }

    public static int countPalindromicIndices(String s, int n) {
        if (s.length() == 1) return 1;
        if (s.length() == 2) return 2;

        if (n % 2 == 0) {
            int result = 2;
            char midChar = s.charAt(n/2);
            for (int i = n/2 + 1, j = n/2 - 2; i < n && j >= 0; i++, j--) {
                if (s.charAt(i) == midChar && s.charAt(j) == midChar) {
                    result = result + 2;
                } else break;
            }
            return result;
        } else {
            int result = 1;
            char midChar = s.charAt(n/2);
            for (int i = n/2 + 1, j = n/2 - 1; i < n && j >= 0; i++, j--) {
                if (s.charAt(i) == midChar && s.charAt(j) == midChar) {
                    result = result + 2;
                } else break;
            }
            return result;
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
