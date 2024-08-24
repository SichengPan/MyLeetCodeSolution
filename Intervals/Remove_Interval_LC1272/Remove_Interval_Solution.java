import java.util.ArrayList;
import java.util.List;

public class Remove_Interval_Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        /** Thoughts:
         1. Go from first to last
         2. Check if the interval overlaps with toBeRemoved
         3. Remove the overlapped part
         */
        List<List<Integer>> intervalsList = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            List<Integer> tempInterval = new ArrayList<>();

            // Interval fully cover toBeRemoved
            if (intervals[i][0] < toBeRemoved[0] && intervals[i][1] > toBeRemoved[1]) {
                int newRight1 = toBeRemoved[0];
                int newLeft2 = toBeRemoved[1];

                List<Integer> tempInterval2 = new ArrayList<>();
                tempInterval.add(intervals[i][0]);
                tempInterval.add(newRight1);

                tempInterval2.add(newLeft2);
                tempInterval2.add(intervals[i][1]);

                intervalsList.add(tempInterval);
                intervalsList.add(tempInterval2);
            } 
            // Interval on the left of toBeRemoved
            else if (intervals[i][0] < toBeRemoved[0]) {
                int newRight = Math.min(intervals[i][1], toBeRemoved[0]);
                tempInterval.add(intervals[i][0]);
                tempInterval.add(newRight);
                intervalsList.add(tempInterval);
            } 
            // Interval on the right of toBeRemoved 
            else if (intervals[i][1] > toBeRemoved[1]) {
                int newLeft = Math.max(toBeRemoved[1], intervals[i][0]);
                tempInterval.add(newLeft);
                tempInterval.add(intervals[i][1]);
                intervalsList.add(tempInterval);
            } 
            // Interval got covered by toBeRemoved
            else if (intervals[i][0] >= toBeRemoved[0] && intervals[i][1] <= toBeRemoved[1]) {
                continue;
            }
        }

        return intervalsList;
    }

    public static void main(String[] args) {
        Remove_Interval_Solution solution = new Remove_Interval_Solution();

        // Test case 1
        int[][] intervals1 = {{0, 2}, {3, 4}, {5, 7}};
        int[] toBeRemoved1 = {1, 6};
        List<List<Integer>> result1 = solution.removeInterval(intervals1, toBeRemoved1);
        System.out.println("Test case 1:");
        printResult(result1); // Expected output: [[0, 1], [6, 7]]

        // Test case 2
        int[][] intervals2 = {{0, 5}};
        int[] toBeRemoved2 = {2, 3};
        List<List<Integer>> result2 = solution.removeInterval(intervals2, toBeRemoved2);
        System.out.println("Test case 2:");
        printResult(result2); // Expected output: [[0, 2], [3, 5]]

        // Test case 3
        int[][] intervals3 = {{0, 100}};
        int[] toBeRemoved3 = {50, 60};
        List<List<Integer>> result3 = solution.removeInterval(intervals3, toBeRemoved3);
        System.out.println("Test case 3:");
        printResult(result3); // Expected output: [[0, 50], [60, 100]]

        // Test case 4: No overlap
        int[][] intervals4 = {{0, 1}, {6, 7}};
        int[] toBeRemoved4 = {2, 5};
        List<List<Integer>> result4 = solution.removeInterval(intervals4, toBeRemoved4);
        System.out.println("Test case 4:");
        printResult(result4); // Expected output: [[0, 1], [6, 7]]
    }

    // Helper method to print the result
    private static void printResult(List<List<Integer>> result) {
        for (List<Integer> interval : result) {
            System.out.println(interval);
        }
    }
}
