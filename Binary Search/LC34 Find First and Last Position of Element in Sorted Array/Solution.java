
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = searchFirst(nums, target);
        int last = searchLast(nums, target);

        return new int[]{first, last};
    }

    private int searchFirst(int[] nums, int target) {
        if (nums == null || nums.length == 0) 
        {
            return -1;  // Handle empty array case
        }

        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        while (start + 1 < end)
        {
            mid = start + (end - start)/2;

            if (nums[mid] < target)
            {
                start = mid;
            }
            else if (nums[mid] > target)
            {
                end = mid;
            }
            else
            {
                end = mid;
            }
        }

        return nums[start] == target ? start : nums[end] == target ? end : -1;
    }

    private int searchLast(int[] nums, int target) {
        if (nums == null || nums.length == 0) 
        {
            return -1;  // Handle empty array case
        }

        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        while (start + 1 < end)
        {
            mid = start + (end - start)/2;

            if (nums[mid] < target)
            {
                start = mid;
            }
            else if (nums[mid] > target)
            {
                end = mid;
            }
            else
            {
                start = mid;
            }
        }

        return nums[end] == target ? end : nums[start] == target ? start : -1;
    }
}
