package com.ilbahar.a2sv.codeforces.round792;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author filbahar
 * @created 19.05.2022
 */
public class Traps {

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int numberOfTest = sc.nextInt();
        for (int i = 0; i < numberOfTest; i++) {
            int[] nk = new int[2];
            String numbers = sc.nextLine();
            String[] str = numbers.split(" ");
            for(int j = 0 ; j < str.length ; j++){
                nk[j]=Integer.parseInt(str[j]);
            }
            int n = nk[0];
            int k = nk[1];
            int[] damages = new int[n];
            String d = sc.nextLine();
            String[] dstr = d.split(" ");
            for (int x = 0; x < dstr.length; x++) {
                damages[x] = Integer.parseInt(dstr[x]);
            }
            out.println(calculateMinDamage(n, k, damages));
        }
        out.close();
    }

    public static int calculateMinDamage(int n, int k, int[] damages) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Pair p = new Pair(i, damages[i]);
            pairs.add(p);
        }
        Collections.sort(pairs);
        int result = 0;
        for (int j = 0; j < n - k; j++) {
            result += pairs.get(j).value + k;
            int numberOfJumpsBigger = n - 1 - pairs.get(j).index;
            result -= numberOfJumpsBigger;
        }
        return result + n - k - 1;
    }

    public static class Pair implements Comparable<Pair> {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            int result = Integer.compare(this.value, o.value);
            if (result == 0) {
                return Integer.compare(this.index, o.index);
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
