
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int i : nums) 
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for(Map.Entry<Integer, Integer> entrySet : countMap.entrySet()) {
            if(buckets[entrySet.getValue()] == null)
                buckets[entrySet.getValue()] = new ArrayList<>();
            buckets[entrySet.getValue()].add(entrySet.getKey());
        }
        
        int[] answer = new int[k];
        for(int i = nums.length; i >= 0 && k > 0; i--) {
            if(buckets[i] != null) {
                for(int j = 0; j < buckets[i].size() && k > 0; j++) 
                    answer[--k] = buckets[i].get(j);
            }
        }

        return answer;
    }
}
