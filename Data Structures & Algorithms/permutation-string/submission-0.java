class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Frequencies = new int[26];
        int[] currentWindowFrequencies = new int[26];

        // initialize both windows
        for(int i = 0; i < s1.length(); i++) {
            s1Frequencies[s1.charAt(i) - 'a']++;
            currentWindowFrequencies[s2.charAt(i) - 'a']++;
        }

        int startIndex = 0;
        int endIndex = startIndex + s1.length() - 1;

        for(int i = s1.length(); i < s2.length(); i++) {
            if(Arrays.equals(s1Frequencies, currentWindowFrequencies))
                return true;

            currentWindowFrequencies[s2.charAt(i - s1.length()) - 'a']--;
            currentWindowFrequencies[s2.charAt(i) - 'a']++;
        }

        return Arrays.equals(s1Frequencies, currentWindowFrequencies);
    }
}
