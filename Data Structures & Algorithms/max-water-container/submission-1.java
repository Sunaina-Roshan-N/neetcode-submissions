class Solution {
    public int maxArea(int[] heights) {
        int startIndex = 0;
        int endIndex = heights.length - 1;

        int maxArea = 0;
        int area = 0;

        while(startIndex < endIndex) {
            area = (Math.min(heights[startIndex], heights[endIndex])) * (endIndex - startIndex);

            if(area > maxArea)
                maxArea = area;

            if(heights[startIndex] > heights[endIndex])
                endIndex--;
            else
                startIndex++;
        }

        return maxArea;
    }
}
