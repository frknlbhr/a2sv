package com.ilbahar.a2sv.leetcode.heap._692;

import java.util.*;

/**
 * @author filbahar
 * @created 24.02.2022
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (frequencyMap.containsKey(word)) {
                frequencyMap.put(word, frequencyMap.get(word) + 1);
            } else {
                frequencyMap.put(word, 1);
            }
        }

        PriorityQueue<WordFrequency> heap = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            heap.add(new WordFrequency(entry.getKey(), entry.getValue() * -1));
        }

        List<String> result = new ArrayList<>();
        while (k != 0) {
            result.add(heap.poll().word);
            k--;
        }
        return result;
    }

    static class WordFrequency implements Comparable<WordFrequency> {
        private final String word;
        private final int frequency;

        public WordFrequency(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(WordFrequency other) {
            if (this.frequency == other.frequency)
                return this.word.compareTo(other.word);
            return Integer.compare(this.frequency, other.frequency);
        }

    }
}
