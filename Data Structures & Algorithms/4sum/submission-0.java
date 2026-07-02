class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        calculateSum(4, 0, target, nums, answer, new ArrayList<>());

        return answer;
    }

    public void calculateSum(int n, int currentIndex, long target, int[] nums, List<List<Integer>> answer, List<Integer> currentStack) {

        if(n == 2) {
            int startIndex = currentIndex;
            int endIndex = nums.length - 1;

            while(startIndex < endIndex) {
                long sum = (long)nums[startIndex] + nums[endIndex];
                if(sum == target) {
                    List<Integer> temp = new ArrayList<>(currentStack);
                    temp.add(nums[startIndex++]);
                    temp.add(nums[endIndex--]);
                    answer.add(temp);

                    while(startIndex < endIndex && nums[startIndex] == nums[startIndex - 1])
                        startIndex++;
                    while(endIndex > startIndex && nums[endIndex] == nums[endIndex + 1])
                        endIndex--;
                } else if (sum > target)
                    endIndex--;
                else
                    startIndex++;
            }
            return;
        }

        for(int i = currentIndex; i < nums.length; i++) {

            if(i > currentIndex && nums[i] == nums[i - 1])
                continue;

            target -= nums[i];
            currentStack.add(nums[i]);

            calculateSum(n - 1, i + 1, target, nums, answer, currentStack);

            currentStack.remove(currentStack.size() - 1);
            target += nums[i];
        }
    }
}