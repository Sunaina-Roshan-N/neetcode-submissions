class NumMatrix {
    private int[][] preprocessedMatrix;
    public NumMatrix(int[][] matrix) {
        int sum = 0;
        preprocessedMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                sum = 0;
                if(i - 1 >= 0)
                    sum += preprocessedMatrix[i - 1][j];
                if(j - 1 >= 0)
                    sum += preprocessedMatrix[i][j - 1];
                if(i - 1 >= 0 && j - 1 >= 0)
                    sum -= preprocessedMatrix[i - 1][j - 1];

                preprocessedMatrix[i][j] = matrix[i][j] + sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = preprocessedMatrix[row2][col2];

        if(col1 - 1 >= 0)
            sum -= preprocessedMatrix[row2][col1 - 1];
        if(row1 - 1 >= 0)
            sum -= preprocessedMatrix[row1 - 1][col2];
        if(col1 - 1 >= 0 && row1 - 1 >= 0)
            sum += preprocessedMatrix[row1 - 1][col1 - 1];
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */