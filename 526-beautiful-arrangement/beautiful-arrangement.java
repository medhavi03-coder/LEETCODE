class Solution {
    private int count = 0; // Class-level variable to store the total count of beautiful arrangements

    /**
     * Calculates the number of beautiful arrangements that can be constructed
     * for n integers labeled 1 through n.
     * A permutation perm (1-indexed) is considered a beautiful arrangement
     * if for every i (1 <= i <= n), either of the following is true:
     * perm[i] is divisible by i.
     * i is divisible by perm[i].
     *
     * @param n The integer representing the range of numbers (1 to n).
     * @return The total number of beautiful arrangements.
     */
    public int countArrangement(int n) {
        // 'visited' array to keep track of numbers already used in the current permutation.
        // Size n+1 because numbers are 1-indexed.
        boolean[] visited = new boolean[n + 1];
        
        // Start the backtracking process from the first position (index 1).
        // We are trying to fill perm[1], perm[2], ..., perm[n].
        backtrack(n, 1, visited); 
        
        return count; // Return the total count found
    }

    /**
     * Recursive helper function to find beautiful arrangements using backtracking.
     *
     * @param n The total number of integers (1 to n).
     * @param position The current 1-indexed position in the permutation we are trying to fill.
     * @param visited A boolean array to track which numbers (1 to n) have already been placed.
     */
    private void backtrack(int n, int position, boolean[] visited) {
        // Base case: If we have successfully filled all 'n' positions (position > n),
        // it means we have found a beautiful arrangement.
        if (position > n) {
            count++; // Increment the total count
            return;
        }

        // Try placing each number from 1 to n at the current 'position'.
        for (int num = 1; num <= n; num++) {
            // Check two conditions before placing 'num':
            // 1. Has 'num' already been used in the current permutation?
            // 2. Does 'num' satisfy the beautiful arrangement condition for the current 'position'?
            //    (i.e., num is divisible by position OR position is divisible by num)
            if (!visited[num] && (num % position == 0 || position % num == 0)) {
                // If conditions met, place 'num' at 'position':
                visited[num] = true; // Mark 'num' as used
                
                // Recursively call for the next position.
                backtrack(n, position + 1, visited);
                
                // Backtrack: Unmark 'num' as used so it can be considered for other positions
                // in different branches of the recursion tree.
                visited[num] = false; 
            }
        }
    }
}
