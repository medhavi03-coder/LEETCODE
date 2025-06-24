class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fibMemo(n, dp);
    }

    private int fibMemo(int n, int[] dp) {
        if (n <= 1) return n;
        int current=0, prev=1,prev2=0;
        for(int i=2;i<=n;i++){
            current=prev+prev2;
            prev2=prev;
            prev=current;
        }
        return current;
// 
        // dp[0]=0;
        // dp[1]=1;
        // for(int i=2; i<=n;i++){
        //     dp[i]= dp[i-1]+ dp[i-2];
        // }
        // if (dp[n] != -1) return dp[n];
// 
        // dp[n] = fibMemo(n - 1, dp) + fibMemo(n - 2, dp);
        // return dp[n];
    }
}
