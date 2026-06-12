class Solution {
    public static void swap(int[] inputArray, int i, int j) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
    }

    public static void medianOf3(int[] inputArray, int mid, int start, int end) {
        if(inputArray[start] > inputArray[mid])
            swap(inputArray, start, mid);
        if(inputArray[mid] > inputArray[end])
            swap(inputArray, mid, end);
        if(inputArray[start] > inputArray[mid])
            swap(inputArray, start, mid);
    }

    public static int partitioning(int[] inputArray, int mid, int start, int end) {
        medianOf3(inputArray, mid, start, end);
        int pivot = inputArray[mid];

        while(start < end) {
            while(start < inputArray.length && inputArray[start] < pivot)
                start++;
            while(end > -1 && inputArray[end] > pivot)
                end--;

            if(start < end)
                swap(inputArray, start++, end--);
        }

        return end;
    }
    public static void quicksort(int[] inputArray, int start, int end) {

        //base case
        if(start >= end)
            return;

        int mid = (start + end)/2;
        mid = partitioning(inputArray, mid, start, end);
        quicksort(inputArray, start, mid);
        quicksort(inputArray, mid + 1, end);
    }
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }
}