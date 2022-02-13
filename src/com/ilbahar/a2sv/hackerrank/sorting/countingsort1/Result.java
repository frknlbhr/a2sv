package com.ilbahar.a2sv.hackerrank.sorting.countingsort1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Result {

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int[] frequencyArray = new int[100];
        for (Integer value : arr) {
            int count = frequencyArray[value];
            frequencyArray[value] = count + 1;
        }
        return IntStream.of(frequencyArray).boxed().collect(Collectors.toList());
    }

}
