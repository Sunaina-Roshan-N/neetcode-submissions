class Solution {
    public void sortColors(int[] nums) {
        int start = 0, mid = 0, high = nums.length - 1;
        int temp;
        while(mid <= high) {
            switch(nums[mid]) {
                case 0:
                    temp = nums[start];
                    nums[start++] = nums[mid];
                    nums[mid++] = temp;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = nums[high];
                    nums[high--] = nums[mid];
                    nums[mid] = temp;
                    break;
            }
        }
        
    }
}