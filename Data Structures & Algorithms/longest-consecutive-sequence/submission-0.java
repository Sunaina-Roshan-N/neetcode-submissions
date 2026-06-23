class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashsetSequence = new HashSet<>();

        for(int num : nums) 
            hashsetSequence.add(num);

        int sequenceStarter = 0;
        int maxSequenceCount = 0;
        int currentSequenceCount = 1;
        for(Integer i : hashsetSequence) {
            
            sequenceStarter = i;
            if(!hashsetSequence.contains(sequenceStarter - 1)) {
            
                while(hashsetSequence.contains(++sequenceStarter)) 
                    currentSequenceCount++;
                
                if(currentSequenceCount > maxSequenceCount)
                    maxSequenceCount = currentSequenceCount;
            }
            currentSequenceCount = 1;
        }

        return maxSequenceCount;
    }
}
