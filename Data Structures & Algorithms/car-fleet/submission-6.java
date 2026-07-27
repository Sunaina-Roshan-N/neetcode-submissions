class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] positionSpeed = new double[position.length][3];

        for(int i = 0; i < position.length; i++) {
            positionSpeed[i][0] = (double)position[i];
            positionSpeed[i][1] = (double)speed[i];
            positionSpeed[i][2] = (double)(target - position[i])/speed[i];
        }

        Arrays.sort(positionSpeed, (a, b) -> Double.compare(b[0], a[0]));
        Stack<Double> fleetCount = new Stack<>();

        for(int i = 0; i < positionSpeed.length; i++) {
            if(!fleetCount.isEmpty() && fleetCount.peek() >= positionSpeed[i][2])
                continue;
            else
                fleetCount.push(positionSpeed[i][2]);
        }

        return fleetCount.size();
    }
}
