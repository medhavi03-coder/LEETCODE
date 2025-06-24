class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fibMemo(n, dp);
    }

    private int fibMemo(int n, int[] dp) {
        if (n <= 1) return n;

        if (dp[n] != -1) return dp[n];

        dp[n] = fibMemo(n - 1, dp) + fibMemo(n - 2, dp);
        return dp[n];
    }
}
