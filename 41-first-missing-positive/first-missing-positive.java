class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Phase 1: Cyclic Sort (Place numbers in their correct positions)
        // A number `x` should ideally be at index `x - 1`.
        for (int i = 0; i < n; i++) {
            // We continue swapping `nums[i]` until one of these conditions is met:
            // 1. `nums[i]` is not a positive number (<= 0).
            // 2. `nums[i]` is greater than `n`.
            // 3. `nums[i]` is already in its correct position (`nums[i] == i + 1`).
            // 4. The number that `nums[i]` *wants* to swap with is a duplicate of `nums[i]`
            //    (i.e., `nums[nums[i] - 1] == nums[i]`). This prevents infinite loops with duplicates.
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int correctIndex = nums[i] - 1;
                // Swap nums[i] with nums[correctIndex]
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Phase 2: Find the first missing positive
        // Iterate through the array and find the first index 'i' where nums[i] is not 'i + 1'.
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Phase 3: All numbers from 1 to n are present
        // If we reach here, it means the array contains all integers from 1 to n.
        // So, the first missing positive integer is n + 1.
        return n + 1;
    }
}