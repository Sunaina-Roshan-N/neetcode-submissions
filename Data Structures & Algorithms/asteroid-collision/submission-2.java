class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> asteroidsLeft = new Stack<>();
        int asteroidToAdd = 0;
        int startIndex = 0;

        while(startIndex < asteroids.length) {
            if(asteroidsLeft.isEmpty())
                asteroidsLeft.push(asteroids[startIndex++]);
            else if((asteroidsLeft.peek() ^ asteroids[startIndex]) < 0 && asteroidsLeft.peek() > asteroids[startIndex]) {
                if(asteroidsLeft.peek() < Math.abs(asteroids[startIndex]))
                    asteroidsLeft.pop();
                else if(asteroidsLeft.peek() == Math.abs(asteroids[startIndex])) {
                    asteroidsLeft.pop();
                    startIndex++;
                } else
                    startIndex++;
            } else
                asteroidsLeft.push(asteroids[startIndex++]);
        }

        return asteroidsLeft.stream().mapToInt(Integer::intValue).toArray();
    }
}