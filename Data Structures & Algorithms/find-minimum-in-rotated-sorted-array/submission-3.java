class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int m = l + (r-l)/2; 

        while (l <= r) {
            System.out.println("l: " + nums[l]);
            System.out.println("m: " + nums[m]);
            System.out.println("r: " + nums[r]);
            System.out.println("\n ============" );
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

        return nums[l];
    }
}
