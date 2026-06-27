class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        int m = (r-l) / 2;
        while(l <= r && m < nums.length && m > -1) {
            if (nums[m] == target)
                return m;
            
            if (nums[m] < target) {
                l = m+1;
                m = l + (r-l) / 2;
            } else {
                r = m-1;
                m = r - (r-l) / 2;
            }
        }
        
        return -1;
    }

    
}
