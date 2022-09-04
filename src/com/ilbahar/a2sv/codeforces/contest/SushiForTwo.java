package com.ilbahar.a2sv.codeforces.contest;

import java.util.*;

/**
 * @author filbahar
 * @created 26.02.2022
 */
public class SushiForTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sushis = new int[n];
        for (int i = 0; i < n; i++) {
            int sushi = scanner.nextInt();
            sushis[i] = sushi;
        }
        System.out.println(solve(sushis));
    }

    public static int solve(int[] sushis) {
        int startIndex = 0;
        Map<Segment, Integer> type1Set = new HashMap<>();
        Map<Segment, Integer> type2Set = new HashMap<>();
        int result = 0;
        for (int i = 0; i < sushis.length; i++) {
            int type = sushis[i];
            if (i != sushis.length - 1) {
                if (type != sushis[i + 1]) {
                    if (type == 1) {
                        Segment s1 = new Segment(startIndex, i);
                        if (s1.length > result / 2 && type2Set.containsKey(s1)) {
                            result = 2 * Math.min(s1.length, type2Set.get(s1));
                        }
                        type1Set.put(s1,s1.length);
                    } else {
                        Segment s2 = new Segment(startIndex, i);
                        if (s2.length > result / 2 && type1Set.containsKey(s2)) {
                            result = 2 * Math.min(s2.length, type1Set.get(s2));
                        }
                        type2Set.put(s2, s2.length);
                    }
                    startIndex = i + 1;
                }
            } else {
                if (type == 1) {
                    Segment s1 = new Segment(startIndex, i);
                    if (s1.length > result / 2 && type2Set.containsKey(s1)) {
                        result = 2 * Math.min(s1.length, type2Set.get(s1));
                    }
                    type1Set.put(s1, s1.length);
                } else {
                    Segment s2 = new Segment(startIndex, i);
                    if (s2.length > result / 2 && type1Set.containsKey(s2)) {
                        result = 2 * Math.min(s2.length, type1Set.get(s2));
                    }
                    type2Set.put(s2, s2.length);
                }
            }
        }
        return result;
    }

    static class Segment {
        int startIndex;
        int endIndex;
        int length;

        public Segment(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.length = endIndex - startIndex + 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Segment segment = (Segment) o;

            return (this.endIndex + 1 == segment.startIndex || this.startIndex - 1 == segment.endIndex);
        }

        @Override
        public int hashCode() {
            return 13 * 31;
        }
    }
}
