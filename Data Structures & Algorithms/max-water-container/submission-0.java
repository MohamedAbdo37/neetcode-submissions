class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int maxArea = 0;

        while (i < j) {
            int area = Math.min(heights[i], heights[j]) * (j - i);
            maxArea = Math.max(area, maxArea);

            if (heights[i] > heights[j])
                j--;
            else if (heights[i] < heights[j])
                i++;
            else {
                if (heights[i + 1] < heights[j - 1])
                    i++;
                else
                    j--;
            }
        }

        return maxArea;
    }
}
