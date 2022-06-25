// https://leetcode.com/problems/course-schedule-iii/
package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {

    public static void main(String[] args) {
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(scheduleCourse(courses));
    }

    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));

        // Max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        int day = 0;
        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];

            if (day + duration <= lastDay) {
                pq.add(duration);
                day += duration;
            } else if (!pq.isEmpty() && pq.peek() > duration) {
                day -= pq.poll();
                pq.add(duration);
                day += duration;
            } else {
                // reject the current course
            }
        }

        return pq.size();
    }
}
