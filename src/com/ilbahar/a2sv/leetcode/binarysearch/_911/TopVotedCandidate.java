package com.ilbahar.a2sv.leetcode.binarysearch._911;

import java.util.HashMap;
import java.util.Map;

/**
 * @author filbahar
 * @created 24.02.2022
 */
class TopVotedCandidate {
    public int[] leader;
    public int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        Map<Integer, Integer> votes = new HashMap<>();
        leader = new int[persons.length];
        this.times = times;
        int lastLeader = -1;
        for (int i = 0; i < persons.length; i++) {
            int candidate = persons[i];
            if (!votes.containsKey(candidate)) {
                votes.put(candidate, 0);
            }
            votes.put(candidate, votes.get(candidate) + 1);
            lastLeader = leader[i] = findLeader(votes, lastLeader, candidate);
        }
    }

    public int q(int t) {
        int left = 0, right = times.length - 1;

        int bestIndex = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (times[mid] <= t) {
                if (t - times[mid] < t - times[bestIndex]) {
                    bestIndex = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return leader[bestIndex];
    }

    public int findLeader(Map<Integer, Integer> votes, int lastLeader, int lastCandidate) {
        int max = -1;
        int leader = 0;
        for (Map.Entry<Integer, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                leader = entry.getKey();
            }
        }

        if (lastLeader != -1) {
            if (max == votes.get(lastCandidate)) {
                return lastCandidate;
            } else if (max == votes.get(lastLeader)) {
                return lastLeader;
            }
        }
        return leader;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
