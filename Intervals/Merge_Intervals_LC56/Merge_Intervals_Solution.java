import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals_Solution {
    public int[][] merge(int[][] intervals) {
        // LeetCode 56
        // Thoughts:
        // 1. First, sort the intervals according to the start
        // 2. Then, go from left to right
        // 3. Check if merge is needed, if so merge two intervals
        // 4. If not insert it into the List
        // 5. Return the List as an Array

        List<int[]> intervalsList = new ArrayList<int[]>();

        // Sort the intervals according to the start
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length; i++) {
            // Pick one out, check if the last interval's end is smaller than its start
            // If so, put it directly in intervalsList, else, merge it with the latest
            int[] tempInterval = intervals[i].clone();

            if (i == 0 || tempInterval[0] > intervalsList.get(intervalsList.size() - 1)[1]) {
                intervalsList.add(tempInterval);
            } else {
                int[] tempLastInterval = intervalsList.get(intervalsList.size() - 1);
                tempLastInterval[1] = Math.max(tempInterval[1], tempLastInterval[1]);
                intervalsList.set(intervalsList.size() - 1, tempLastInterval);
            }
        }

        return intervalsList.toArray(new int[intervalsList.size()][]);
    }

    public static void main(String[] args) {
        Merge_Intervals_Solution solution = new Merge_Intervals_Solution();

        // Test case 1
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result1 = solution.merge(intervals1);
        System.out.println("Test case 1:");
        printResult(result1); // Expected output: [[1, 6], [8, 10], [15, 18]]

        // Test case 2
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] result2 = solution.merge(intervals2);
        System.out.println("Test case 2:");
        printResult(result2); // Expected output: [[1, 5]]
    }

    // Helper method to print the result
    private static void printResult(int[][] result) {
        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval) + " ");
        }
        System.out.println();
    }
}
