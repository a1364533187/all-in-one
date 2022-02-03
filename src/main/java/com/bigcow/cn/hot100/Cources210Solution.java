package com.bigcow.cn.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Cources210Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][0]]++;
            List<Integer> courses = courseMap.getOrDefault(prerequisites[i][1], new ArrayList<>());
            courses.add(prerequisites[i][0]);
            courseMap.put(prerequisites[i][1], courses);
        }
        Queue<Integer> degree0Queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                degree0Queue.add(i);
            }
        }
        int visitedCourse = 0;
        int[] res = new int[numCourses];
        while (!degree0Queue.isEmpty()) {
            int degree = degree0Queue.poll();
            res[visitedCourse] = degree;
            visitedCourse++;
            List<Integer> courses = courseMap.getOrDefault(degree, new ArrayList<>());
            for (int i = 0; i < courses.size(); i++) {
                indegrees[courses.get(i)]--;
                if (indegrees[courses.get(i)] == 0) {
                    degree0Queue.add(courses.get(i));
                }
            }
        }
        if (visitedCourse == numCourses) {
            return res;
        } else {
            return new int[] {};
        }
    }
}
