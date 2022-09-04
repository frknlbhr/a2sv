package com.ilbahar.a2sv.codeforces.round792;


import java.io.*;
import java.util.StringTokenizer;

public class ZModXEqualsC {

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int numberOfTest = sc.nextInt();
        for (int i = 0; i < numberOfTest; i++) {
            int[] abc = new int[3];
            String numbers = sc.nextLine();
            String[] str = numbers.split(" ");
            for(int j = 0 ; j < str.length ; j++){
                abc[j]=Integer.parseInt(str[j]);
            }
            String[] result = findXYZ(abc);
            String joined = String.join(" ", result);
            out.println(joined);
        }
        out.close();
    }

    public static String[] findXYZ(int[] abc) {
        String[] result = new String[3];
        result[2] = String.valueOf(abc[2]);
        result[1] = String.valueOf(abc[1] + abc[2]);
        result[0] = String.valueOf(abc[0] + abc[1] + abc[2]);
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
