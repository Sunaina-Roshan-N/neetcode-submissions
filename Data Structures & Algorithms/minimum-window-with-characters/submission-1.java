class Solution {
    public String minWindow(String s, String t) {
         // compare the two strings
        if(s.length() < t.length())
            return "";

        // Count the characters of the t string
        HashMap<Character, Integer> tStringCharacterCount = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            tStringCharacterCount.put(t.charAt(i), tStringCharacterCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        //find the start of the window
        int startIndex = 0;
        int endIndex = startIndex;
        int tally = 0;
        int currentCharacterCount = 0;
        String answer = "";
        int currentSize = s.length() + 1;

        while(startIndex <= endIndex) {
            
            //find the next character
            while(startIndex < s.length() && !tStringCharacterCount.containsKey(s.charAt(startIndex)))
                startIndex++;

            if(startIndex > endIndex)
                endIndex = startIndex;

            // search for end of the window [which is all the character counts]
            while(endIndex < s.length() && tally < tStringCharacterCount.size()) {
                if(tStringCharacterCount.containsKey(s.charAt(endIndex))) {
                    currentCharacterCount = tStringCharacterCount.get(s.charAt(endIndex)) - 1;
                    tStringCharacterCount.put(s.charAt(endIndex), currentCharacterCount);
                    tally = currentCharacterCount == 0 ? tally + 1 : tally;
                }
                endIndex++;
            }
            
            if(tally == tStringCharacterCount.size()) {
                if(endIndex - startIndex < currentSize) {
                    currentSize = endIndex - startIndex;
                    answer = s.substring(startIndex, endIndex);
                }
            }

            if(startIndex < s.length()) {
                //reset values
                currentCharacterCount = tStringCharacterCount.get(s.charAt(startIndex)) + 1;
                tStringCharacterCount.put(s.charAt(startIndex), currentCharacterCount);
                if(currentCharacterCount > 0)
                    tally--;
            }
            
            startIndex++;
            // loop through to find the next window
        }
        return answer;
    }
}
