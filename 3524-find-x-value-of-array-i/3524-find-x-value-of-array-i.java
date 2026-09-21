class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] temp = new long[k];
            int value = num % k;

            temp[value]++;

            for (int r = 0; r < k; r++) {
                int rem = (r * value) % k;
                temp[rem] += dp[r];
            }

            for (int r = 0; r < k; r++) {
                ans[r] += temp[r];
            }

            dp = temp;
        }

        return ans;
    }
}