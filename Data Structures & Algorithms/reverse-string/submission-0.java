class Solution {
    public void reverseString(char[] s) {
        char temp;
        int beginning = 0;
        int end = s.length - 1;

        while(end > beginning) {
            temp = s[beginning];
            s[beginning++] = s[end];
            s[end--] = temp;
        }
    }
}