import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        
        int left = 0;
        int sum = 0;
        int minSoFar = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            
            if (sum == target) {
                int currentLen = right - left + 1;
                
                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, currentLen + minLen[left - 1]);
                }
                
                minSoFar = Math.min(minSoFar, currentLen);
            }
            
            minLen[right] = minSoFar;
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}