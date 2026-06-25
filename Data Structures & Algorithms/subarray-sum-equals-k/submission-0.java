class Solution {
    public int subarraySum(int[] nums, int k) {
        int totalFrequency = 0;
        HashMap<Integer, Integer> mapFrequency = new HashMap<>();
        mapFrequency.put(0,1);
        int currentSum = 0;
        int pastSum = 0;
        for(int num : nums) {
            currentSum += num;
            pastSum = currentSum - k;

            totalFrequency += mapFrequency.getOrDefault(pastSum, 0);

            mapFrequency.put(currentSum, mapFrequency.getOrDefault(currentSum, 0) + 1);
        }

        return totalFrequency;
    }
}