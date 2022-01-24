package com.bigcow.cn.code.tree.BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GetImportance690Solution {

    public static void main(String[] args) {
        // [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            employeeMap.put(employees.get(i).id, employees.get(i));
        }
        // 进行BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        int importance = 0;
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            Employee employee = employeeMap.get(curId);
            importance += employee.importance;
            for (int subordinate : employee.subordinates) {
                queue.add(subordinate);
            }
        }
        return importance;
    }

    class Employee {

        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}
