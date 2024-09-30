class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1)
        {
            return nums[0] == target ? 0 : -1;
        }

        int pivot = findPivot(nums);
        int start = 0;
        int end = nums.length - 1;

        // search left
        int resultLeft = searchSubArray(nums, start, pivot-1, target);
        // search right
        int resultRight = searchSubArray(nums, pivot, end, target);
        
        return resultLeft == -1 ? resultRight : resultLeft;
    }

    private int searchSubArray(int[] nums, int start, int end, int target){
        if (start >= end)
        {
            return nums[start] == target ? start : -1; 
        }

        while (start+1 < end)
        {
            int mid = start + (end - start)/2;

            if (nums[mid] == target)
            {
                return mid;
            }
            else if (nums[mid] < target)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return nums[start] == target ? start : nums[end] == target ? end : -1;
    }

    private int findPivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        while (start+1 < end)
        {
            int mid = start + (end - start)/2;

            if (nums[mid] > nums[end])
            {
                start = mid;
            }
            else
            {
                end = mid;
            }
        }

        return nums[start] < nums[end] ? start : end;
    }
}