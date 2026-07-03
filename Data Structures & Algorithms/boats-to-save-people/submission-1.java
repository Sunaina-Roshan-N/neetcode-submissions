class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int startIndex = 0;
        int endIndex = people.length - 1;

        int currentLimit = 0;
        int countBoats = 0;

        while(startIndex <= endIndex) {

            // sum of start and end == limit -> add a count for a boat
            // sum of start and end < limit -> change indices and check again
            if(startIndex == endIndex) {
                countBoats++;
                break;
            } else {
                currentLimit = people[startIndex] + people[endIndex];

                if(currentLimit > limit) {
                    endIndex--;
                    countBoats++;
                } else if(currentLimit <= limit) {
                    countBoats++;
                    startIndex++;
                    endIndex--;
                }
            }
        }

        return countBoats;
    }
}