class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while(endIndex - startIndex + 1 != k) {
            if(arr[endIndex] - x < x - arr[startIndex])
                startIndex++;
            else
                endIndex--;
        }

        List<Integer> answer = new ArrayList<>();

        for(int i = startIndex; i <= endIndex; i++) {
            answer.add(arr[i]);
        }

        return answer;
    }
}