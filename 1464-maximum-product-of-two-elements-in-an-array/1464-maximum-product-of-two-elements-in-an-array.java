class Solution {
    public int maxProduct(int[] nums) {
        int max =0;int secmax =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                secmax = max ;
                max = nums[i];

            }else if(nums[i]>secmax){
                secmax = nums[i];
            }
        }
        return (max -1 )* (secmax-1);
    }
}