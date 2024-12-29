package com.company.amazon.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // inDegree to maintain the number of courses we need to complete before
        // taking a course
        var inDegree = new int[numCourses];
        var graph = new HashMap<Integer, List<Integer>>();
        for (var prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            inDegree[v]++;
        }

        var queue = new ArrayDeque<Integer>();
        // add courses which do not have any prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int coursesTaken = 0;
        while (!queue.isEmpty()) {
            // completed this course and taking next courses
            int course = queue.poll();
            coursesTaken++;
            for (int nextCourse : graph.getOrDefault(course, new ArrayList<>())) {
                // remove the prerequisite for this course
                inDegree[nextCourse]--;

                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return coursesTaken == numCourses;
    }
}
