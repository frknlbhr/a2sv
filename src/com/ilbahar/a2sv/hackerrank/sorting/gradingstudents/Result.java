package com.ilbahar.a2sv.hackerrank.sorting.gradingstudents;

import java.util.ArrayList;
import java.util.List;

public class Result {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> results = new ArrayList<>();
        for (Integer grade : grades) {
            if (grade < 38) {
                results.add(grade);
                continue;
            }
            int mod = grade % 5;
            if (mod > 2) {
                results.add(grade + (5 - mod));
            }
            else {
                results.add(grade);
            }
        }
        return results;
    }

}
