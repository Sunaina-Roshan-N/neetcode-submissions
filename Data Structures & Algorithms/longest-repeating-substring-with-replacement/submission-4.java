class Solution {
    public int characterReplacement(String s, int k) {
        int startIndex = 0;
        int endIndex = 1;
        char mostFrequent = s.charAt(0);

        HashMap<Character, Integer> currentFrequency = new HashMap<>();
        currentFrequency.put(mostFrequent, 1);
        int maxLength = 0;
        int currentLength = 1;
        int currentValue = 0;
        
        while(endIndex != s.length()) {
            currentValue = currentFrequency.getOrDefault(s.charAt(endIndex), 0) + 1;
            currentFrequency.put(s.charAt(endIndex), currentValue);
            // check if it is the most frequent one
            if(currentValue > currentFrequency.get(mostFrequent))
                mostFrequent = s.charAt(endIndex);

            // Check if even with replacing the other characters, it would be the longest repeating character in this window
            currentLength = endIndex - startIndex + 1;
            if(currentLength - currentFrequency.get(mostFrequent) <= k && currentLength > maxLength)
                maxLength = currentLength;

            else {
                // replacing characters is not enough
                // reset the window's start Index
                currentFrequency.put(s.charAt(startIndex), currentFrequency.get(s.charAt(startIndex)) - 1);
                startIndex++;
            }

            endIndex++;
        }

        return maxLength;
        
    }
}
