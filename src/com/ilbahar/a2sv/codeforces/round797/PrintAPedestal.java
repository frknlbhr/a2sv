package com.ilbahar.a2sv.codeforces.round797;

import com.ilbahar.a2sv.codeforces.round129.GameWithCards;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author filbahar
 * @created 7.06.2022
 */
public class PrintAPedestal {

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int numberOfTest = sc.nextInt();
        for (int i = 0; i < numberOfTest; i++) {
            int n = sc.nextInt();
            String[] result = solve(n);
            String joined = String.join(" ", result);
            out.println(joined);
        }
        out.close();
    }

    public static String[] solve(int n) {
        String[] result = new String[3];
        int p1 = 0;
        if (n % 3 == 0) p1 = n / 3 + 1;
        else p1 = (n / 3) + 2;
        int p2Andp3 = n - p1;
        int p3 = p2Andp3 / 2 - 1;
        if (p3 < 1) p3 = 1;
        int p2 = p2Andp3 - p3;
        if (p2 == p1) {
            p2 = p2 - 1;
            p3 = p3 + 1;
        }
        result[2] = String.valueOf(p3);
        result[1] = String.valueOf(p1);
        result[0] = String.valueOf(p2);
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
