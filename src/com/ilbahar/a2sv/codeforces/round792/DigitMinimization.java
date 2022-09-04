package com.ilbahar.a2sv.codeforces.round792;

import java.io.*;
import java.util.StringTokenizer;

public class DigitMinimization {

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int numberOfTest = sc.nextInt();
        for (int i = 0; i < numberOfTest; i++) {
            int n = sc.nextInt();
            int result = findMinOfAlice(n);
            out.println(result);
        }
        out.close();
    }

    public static int findMinOfAlice(int n) {
        String strNumber = String.valueOf(n);
        if (strNumber.length() == 2) {
            return Character.getNumericValue(strNumber.charAt(1));
        } else {
            int min = Integer.MAX_VALUE;
            for (Character c : strNumber.toCharArray()) {
                int nmbr = Character.getNumericValue(c);
                if (nmbr < min) {
                    min = nmbr;
                }
            }
            return min;
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
