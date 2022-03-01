package com.ilbahar.a2sv.leetcode.dfs._690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author filbahar
 * @created 2.03.2022
 */
public class Solution {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> idEmployeeMap = new HashMap<>();
        for (Employee emp : employees) {
            idEmployeeMap.put(emp.id, emp);
        }
        return dfs(id, idEmployeeMap);
    }

    private int dfs(int id, Map<Integer, Employee> idEmployeeMap) {
        Employee emp = idEmployeeMap.get(id);
        int importance = 0;
        for (Integer sub : emp.subordinates) {
            importance += dfs(sub, idEmployeeMap);
        }
        return importance + emp.importance;
    }

}
