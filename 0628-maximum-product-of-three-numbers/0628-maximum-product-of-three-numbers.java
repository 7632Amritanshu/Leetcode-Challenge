class Solution {
    public int maximumProduct(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d=Integer.MAX_VALUE;
        int e = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>a){
                c=b;
                b=a;
                a=nums[i];
            }else if(nums[i]>b){
                c=b;
                b = nums[i];
            }else if(nums[i]>c){
                c=nums[i];
            }

            if(nums[i]<d){
                e=d;
                d=nums[i];
            }else if(nums[i]<e){
                e=nums[i];
            }

        }
        return  Math.max(a*b*c , d*e*a);
    }
}