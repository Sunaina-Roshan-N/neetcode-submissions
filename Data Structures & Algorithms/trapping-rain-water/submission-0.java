class Solution {
    public int trap(int[] height) {
        int startIndex = 0;
        int endIndex = height.length - 1;
        int smallestWall = 0;

        int currentMinWall = 0;
        int currentArea = 0;

        while(startIndex < endIndex) {
            
            currentMinWall = Math.min(height[startIndex], height[endIndex]);
            if(currentMinWall > smallestWall) {
                currentArea += ((currentMinWall - smallestWall) * (endIndex - startIndex - 1)) - smallestWall;
                smallestWall = currentMinWall;
            } else 
                currentArea -= currentMinWall;
            

            if(height[startIndex] > height[endIndex]) 
                endIndex--;
            else
                startIndex++;

            
        }

        return currentArea;
    }
}
