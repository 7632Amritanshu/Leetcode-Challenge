class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List <Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
             if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int j=i+1;
            int k = nums.length-1;
              
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum == 0) {
                    // Found a valid triplet, add it using the bulk method
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    
                    // 3. Skip duplicates for the second position
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    // 4. Skip duplicates for the third position
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    
                    // Move pointers inward after finding a match
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++; 
                } else {
                    k--; // Sum is too large, move right pointer left to decrease sum
                }
            }
            
        }
        return list;
    }
}