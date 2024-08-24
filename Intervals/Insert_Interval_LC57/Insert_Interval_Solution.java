//package Insert_Interval_LC57;

import java.util.ArrayList;
import java.util.List;

public class Insert_Interval_Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // LeetCode 57: Insert Interval
        // Thoughts:
        // 1. Go through each interval
        // 2. Check if newInterval[0] is greater than its[1]
        // 3. If so, put the interval into the array
        // 4. Else, check if the newInterval[1] is smaller than its[0], if so, put the new interval into the array
        // 5. Else, choose [smallest of newInterval[0] and interval[0], greatest of newInterval[1] and interval[1]], to be the new newInterval, move to next
        // 6. Document if newInterval is inserted, if not, insert it in the end

        List<int[]> intervalsList = new ArrayList<>();
        boolean isAdded = false;

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] > intervals[i][1]) {
                intervalsList.add(intervals[i]);
            } else if (newInterval[1] < intervals[i][0]) {
                if (!isAdded) {
                    intervalsList.add(newInterval);
                    isAdded = true;
                }
                intervalsList.add(intervals[i]);
            } else {
                int newIntervalLeft = Math.min(newInterval[0], intervals[i][0]);
                int newIntervalRight = Math.max(newInterval[1], intervals[i][1]);
                newInterval = new int[]{newIntervalLeft, newIntervalRight};
            }
        }

        if (!isAdded) {
            intervalsList.add(newInterval);
        }

        return intervalsList.toArray(new int[intervalsList.size()][]);
    }

    public static void main(String[] args) {
        Insert_Interval_Solution solution = new Insert_Interval_Solution();

        // Test case 1
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] result1 = solution.insert(intervals1, newInterval1);
        System.out.println("Test case 1:");
        printResult(result1); // Expected output: [[1, 5], [6, 9]]

        // Test case 2
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        int[][] result2 = solution.insert(intervals2, newInterval2);
        System.out.println("Test case 2:");
        printResult(result2); // Expected output: [[1, 2], [3, 10], [12, 16]]

        // Test case 3: Empty intervals
        int[][] intervals3 = {};
        int[] newInterval3 = {5, 7};
        int[][] result3 = solution.insert(intervals3, newInterval3);
        System.out.println("Test case 3:");
        printResult(result3); // Expected output: [[5, 7]]

        // Test case 4: Single interval, newInterval before it
        int[][] intervals4 = {{10, 12}};
        int[] newInterval4 = {5, 7};
        int[][] result4 = solution.insert(intervals4, newInterval4);
        System.out.println("Test case 4:");
        printResult(result4); // Expected output: [[5, 7], [10, 12]]

        // Test case 5: Single interval, newInterval after it
        int[][] intervals5 = {{1, 2}};
        int[] newInterval5 = {3, 5};
        int[][] result5 = solution.insert(intervals5, newInterval5);
        System.out.println("Test case 5:");
        printResult(result5); // Expected output: [[1, 2], [3, 5]]
    }

    // Helper method to print the result
    private static void printResult(int[][] result) {
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
    }
}
