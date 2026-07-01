class Solution {
    public boolean validPalindrome(String s) {
        int beginning = 0;
        int end = s.length() - 1;

        while(end > beginning) {

            if(s.charAt(beginning) != s.charAt(end)) {
                return isPalindrome(s, beginning+1, end) || isPalindrome(s, beginning, end -1);
            } 
            end--;
            beginning++;
        }
        return true;
    }

    public boolean isPalindrome(String s, int beginning, int end) {
        while(end > beginning) {

            if(s.charAt(beginning) != s.charAt(end)) {
                return false;
            } 
            end--;
            beginning++;
        }
        return true;
    
    }
}