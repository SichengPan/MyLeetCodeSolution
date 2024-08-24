import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Remove_Covered_Intervals {
    public int removeCoveredIntervals(int[][] intervals) {
        /* Thoughts:
        1. Sort it by the start, ascending
        2. Go left to right
        3. Check if this one got covered by the last one in intervalsList, if so, continue
        */
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> intervalsList = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (intervalsList.size() == 0) {
                intervalsList.add(intervals[i]);
            } else if (intervals[i][1] > intervalsList.get(intervalsList.size() - 1)[1]) {
                if (intervals[i][0] == intervalsList.get(intervalsList.size() - 1)[0]) {
                    intervalsList.set(intervalsList.size() - 1, intervals[i]);
                } else {
                    intervalsList.add(intervals[i]);
                }
            }
        }

        return intervalsList.size();
    }

    public static void main(String[] args) {
        Remove_Covered_Intervals solution = new Remove_Covered_Intervals();

        // Test case 1
        int[][] intervals1 = {{1, 4}, {3, 6}, {2, 8}};
        int result1 = solution.removeCoveredIntervals(intervals1);
        System.out.println("Test case 1: " + result1); // Expected output: 2

        // Test case 2
        int[][] intervals2 = {{1, 4}, {2, 3}};
        int result2 = solution.removeCoveredIntervals(intervals2);
        System.out.println("Test case 2: " + result2); // Expected output: 1

        // Test case 3
        int[][] intervals3 = {{1, 2}, {1, 4}, {3, 4}};
        int result3 = solution.removeCoveredIntervals(intervals3);
        System.out.println("Test case 3: " + result3); // Expected output: 1
    }
}
