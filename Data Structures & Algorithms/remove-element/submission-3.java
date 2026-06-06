class Solution {
    public int removeElement(int[] nums, int val) {
        int k = nums.length - 1; 
        
        for(int i = 0; i <= k; i++) {
            if(nums[i] == val) {
                while(nums[k] == val && k > i) 
                    k--;
                if(k == i)
                    return k;
                nums[i] = nums[k];
                k--;
            }    
        }   
        return k + 1;
    }
}