class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length * matrix[0].length - 1;
        int m = l + (r-l)/2;
        int m1 = m / matrix[0].length;
        int m2 = m - m1 * matrix[0].length;
        while (l <= r) {
                
            if (matrix[m1][m2] == target)
                return true;
            
            if (matrix[m1][m2] < target) {
                l = m+1;
                m = l + (r-l)/2;
            
            } else {
                r = m-1;
                m = l + (r-l)/2;
            } 
            m1 = m / matrix[0].length;
            m2 = m - m1 * matrix[0].length;
        }      

        return false;
    }
}
