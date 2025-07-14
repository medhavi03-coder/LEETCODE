import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        // Map to store the first occurrence of each running sum
        // Key: running sum
        // Value: index where this sum was first encountered
        Map<Integer, Integer> sumMap = new HashMap<>();

        // Initialize with sum 0 at index -1. This handles cases where the
        // subarray with equal 0s and 1s starts from the beginning of the array.
        // If sum becomes 0 at index i, length is i - (-1) = i + 1.
        sumMap.put(0, -1);

        int maxLength = 0;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Transform 0s to -1s and 1s to 1s
            currentSum += (nums[i] == 0 ? -1 : 1);

            // If the current sum has been seen before
            if (sumMap.containsKey(currentSum)) {
                // Calculate the length of the subarray
                // from the previous occurrence of this sum to the current index
                maxLength = Math.max(maxLength, i - sumMap.get(currentSum));
            } else {
                // If this sum is encountered for the first time, store its index
                sumMap.put(currentSum, i);
            }
        }

        return maxLength;
    }
}