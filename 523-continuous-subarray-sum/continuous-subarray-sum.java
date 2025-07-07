import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> modIndex = new HashMap<>();
        modIndex.put(0, -1); // base case for subarrays starting at index 0

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int mod = (k != 0) ? sum % k : sum;

            if (modIndex.containsKey(mod)) {
                int prevIndex = modIndex.get(mod);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                modIndex.put(mod, i);  // only put the first occurrence
            }
        }

        return false;
    }
}
