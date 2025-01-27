package com.bigcow.cn.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Courses207Solution {

    public static void main(String[] args) {
        int[][] prerequisites = new int[][] { { 3, 0 }, { 3, 1 }, { 4, 1 }, { 4, 2 }, { 5, 3 },
                { 5, 4 } };
        System.out.println(canFinish(6, prerequisites));
    }

    /**
     * 类似于判断图是否有环
     * 1、拓扑排序
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while (!degree0Queue.isEmpty()) {
            int degree = degree0Queue.poll();
            visitedCourse++;
            List<Integer> courses = courseMap.getOrDefault(degree, new ArrayList<>());
            for (int i = 0; i < courses.size(); i++) {
                indegrees[courses.get(i)]--;
                if (indegrees[courses.get(i)] == 0) {
                    degree0Queue.add(courses.get(i));
                }
            }
        }
        return visitedCourse == numCourses;
    }
}
