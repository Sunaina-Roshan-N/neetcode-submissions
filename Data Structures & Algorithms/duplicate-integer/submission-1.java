class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> numberCheck = new HashSet<>();
		 
		 for(int i = 0; i < nums.length; i++) {
			 if(numberCheck.contains(nums[i]))
				 return true;
			 numberCheck.add(nums[i]);
		 }
		 
		 return false;
    }
}
