class Solution {
    public void rotate(int[] nums, int k) {
        int previousElement = 0;
        int rotateIndex = 0;
        int temp;
        int count = 0;

        k %= nums.length;

        for(int i = 0; count != nums.length; i++) {
            previousElement = nums[i];
            rotateIndex = i + k;

            while(rotateIndex != i) {
                temp = nums[rotateIndex];
                nums[rotateIndex] = previousElement;
                previousElement = temp;

                rotateIndex = (rotateIndex + k)%nums.length;
                count++;
            }
            nums[i] = previousElement;
            count++;
        }
    }
}