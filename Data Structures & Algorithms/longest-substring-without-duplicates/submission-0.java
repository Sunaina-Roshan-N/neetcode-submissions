class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> seen = new HashMap<>();

        int startIndex = 0;
        int currentLength = 0;
        int maxLength = 0;

        for(int i = 0; i < s.length(); i++) {
            
            if(seen.containsKey(s.charAt(i)) && seen.get(s.charAt(i)) >= startIndex) {
                startIndex = seen.get(s.charAt(i)) + 1;
                currentLength = i - startIndex + 1;
            } else
                currentLength++;
                
            seen.put(s.charAt(i), i);

            if(currentLength > maxLength)
                maxLength = currentLength;
        }

        return maxLength;
    }
}
