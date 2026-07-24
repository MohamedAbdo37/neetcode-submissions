class Solution {
    public int largestRectangleArea(int[] heights) {
        int l, r, area = 0;

        for( int i = 0; i < heights.length;i++) {
            l = i-1;
            r = i+1;
            for(; l > -1; l--)
                if(heights[l] < heights[i])
                    break;
            
            for(; r < heights.length; r++)
                if(heights[r] < heights[i])
                    break;
            r--;

            area = Math.max(area, (r-l)*heights[i]);
        }

        return area;
    }
}
