class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int min = this.getMin(nums);

        if (target == nums[r])
            return r;
        if (target == nums[min])
            return min;
        if (target == nums[l])
            return l;

        if ( min != r && target > nums[min] && target < nums[r] )
            return this.search(nums, target, min, r);
        if ( min != l && target > nums[l] && target <= nums[min-1] )
            return this.search(nums, target, l, min-1);

       return -1;
    }

    public int search(int[]nums, int t, int l, int r){
        int m = l + (r-l) /2;
        while (l <=r ){
            if(nums[m]==t)
                return m;
            if(nums[m] < t){
                l = m+1;
                m = l + (r-l) /2;
            } else {
                r = m - 1;
                m = l + (r-l) / 2;
            }
        }

        return -1;
    }

    public int getMin(int[] nums){
        int l = 0;
        int r = nums.length-1;
        int m = l + (r-l)/2; 

        while (l <= r) {
            if(l == r)
                break;
            
            if (nums[m] > nums[r]) {
                l = m+1;
                m = l + (r-l)/2;  
            } else {
                r = m;
                m = l + (r-l)/2; 
            }
            
        }

        return l;
    }
}
