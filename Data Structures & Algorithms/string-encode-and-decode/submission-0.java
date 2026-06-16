class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        String hash = "#";
        for(String inputString : strs) 
            encodedString.append(String.valueOf(inputString.length())).append(hash).append(inputString);
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStringList = new ArrayList<>();
        int start = 0;
        int end = 0;
        int lengthOfString = -1;
        while(end < str.length()) {
            if(str.charAt(end) == '#') {
                // fetch the integer
                try {
                    lengthOfString = Integer.parseInt(str.substring(start, end));
                    // check if you can fetch it otherwise it is part of the string and you have to continue
                    // Fetch the String from length
                    decodedStringList.add(str.substring(end + 1, end + lengthOfString + 1));
                    // Update pointers
                    start = end + lengthOfString + 1;
                    end = start;
                } catch (Exception e) {
                    
                }
                
            }
            end++;
        }
        return decodedStringList;
    }
}
