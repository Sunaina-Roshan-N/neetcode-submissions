class Solution {
    public int removeDuplicates(int[] nums) {
        int fill = 0;
        int nextUniqueNumber = fill + 1;

        while(nextUniqueNumber < nums.length) {
            if(nums[fill] != nums[nextUniqueNumber]) {
                nums[++fill] = nums[nextUniqueNumber];
            }
            nextUniqueNumber++;
        }

        return fill + 1;
    }
}