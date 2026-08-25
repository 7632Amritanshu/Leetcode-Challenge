class Solution {
    public int missingMultiple(int[] nums, int k) {
        int i=1;
        while(true){
            int num = k*i;
            if(found(nums,num)==-1){
                return num;
            }
            i++;
        }
        
    }
    public int found(int[] nums,int target){
       for(int i=0;i<nums.length;i++){
        if(nums[i]==target){
            return i;
        }
       }
       return -1;
    }
}