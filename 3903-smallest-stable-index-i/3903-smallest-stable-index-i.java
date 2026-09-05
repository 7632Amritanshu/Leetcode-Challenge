class Solution {
    public int firstStableIndex(int[] nums, int k) {
         int[] right = new int[nums.length];
        right[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            right[i]= Math.min(right[i+1],nums[i]);
        }
        int max =0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            if(max-right[i]<=k){
                return i;
            }
        }
        return -1;
    }
}