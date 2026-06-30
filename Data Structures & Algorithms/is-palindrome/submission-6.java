class Solution {
    public boolean isPalindrome(String s) {
        int beginning = 0;
        int end = s.length() - 1;

        while(end > beginning) {
            if(!Character.isLetterOrDigit(s.charAt(beginning)))
                beginning++;
            else if(!Character.isLetterOrDigit(s.charAt(end)))
                end--;
            else if(Character.toLowerCase(s.charAt(beginning++)) != Character.toLowerCase(s.charAt(end--))) 
                return false;

        }

        return true;
    }
}
