//package Interval_List_Intersections_LC986;

import java.util.ArrayList;
import java.util.List;

public class Interval_List_Intersections_Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // LeetCode 986: Interval List Intersections
        // Thoughts:
        // 1. Get two pointers i, j
        // 2. i for firstList, j for secondList
        // 3. Check if they have intersection, if so, calculate it
        // 4. For that one with a smaller end point, move it forward by 1

        List<int[]> intervalsList = new ArrayList<>();
        int i = 0, j = 0;
        int lengthFirst = firstList.length, lengthSecond = secondList.length;

        while (i < lengthFirst && j < lengthSecond) {
            if (firstList[i][0] <= secondList[j][1] && secondList[j][0] <= firstList[i][1]) {
                int[] tempList = new int[]{Math.max(firstList[i][0], secondList[j][0]), Math.min(firstList[i][1], secondList[j][1])};
                intervalsList.add(tempList);
            }

            if (firstList[i][1] > secondList[j][1]) {
                j++;
            } else {
                i++;
            }
        }

        return intervalsList.toArray(new int[intervalsList.size()][]);
    }

    public static void main(String[] args) {
        Interval_List_Intersections_Solution solution = new Interval_List_Intersections_Solution();

        // Test case 1
        int[][] firstList1 = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList1 = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] result1 = solution.intervalIntersection(firstList1, secondList1);
        System.out.println("Test case 1:");
        printResult(result1); // Expected output: [[1, 2], [5, 5], [8, 10], [15, 23], [24, 24], [25, 25]]

        // Test case 2
        int[][] firstList2 = {{1, 3}, {5, 9}};
        int[][] secondList2 = {};
        int[][] result2 = solution.intervalIntersection(firstList2, secondList2);
        System.out.println("Test case 2:");
        printResult(result2); // Expected output: []

        // Test case 3
        int[][] firstList3 = {};
        int[][] secondList3 = {{4, 8}, {10, 12}};
        int[][] result3 = solution.intervalIntersection(firstList3, secondList3);
        System.out.println("Test case 3:");
        printResult(result3); // Expected output: []

        // Test case 4
        int[][] firstList4 = {{1, 7}};
        int[][] secondList4 = {{3, 10}};
        int[][] result4 = solution.intervalIntersection(firstList4, secondList4);
        System.out.println("Test case 4:");
        printResult(result4); // Expected output: [[3, 7]]
    }

    // Helper method to print the result
    private static void printResult(int[][] result) {
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
    }
}
