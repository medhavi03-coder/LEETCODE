class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];  // Initialize with the first element
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either extend the previous subarray or start a new one at current element
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);  // Update maxSum if needed
        }

        return maxSum;
    }
}
