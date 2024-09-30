/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 class Solution {
    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = 1;

        while (reader.get(end) != Integer.MAX_VALUE && reader.get(end) < target)
        {
            end = end * 2;
        }

        while (start+1 < end)
        {
            int mid = start + (end - start)/2;

            if (reader.get(mid) != Integer.MAX_VALUE && reader.get(mid) == target)
            {
                return mid;
            }
            else if (reader.get(mid) == Integer.MAX_VALUE || reader.get(mid) > target)
            {
                end = mid;
            }
            else
            {
                start = mid;
            }
        }
        
        return reader.get(start) == target ? start : reader.get(end) == target ? end : -1;
    }
}