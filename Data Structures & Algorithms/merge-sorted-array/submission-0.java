class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = m - 1;
        int nums2Index = n - 1;
        int index = nums1.length - 1;
        while(nums2Index != -1) {
            if(nums1Index != -1 && nums1[nums1Index] > nums2[nums2Index]) 
                nums1[index--] = nums1[nums1Index--];
            else 
                nums1[index--] = nums2[nums2Index--];
        }
    }
}