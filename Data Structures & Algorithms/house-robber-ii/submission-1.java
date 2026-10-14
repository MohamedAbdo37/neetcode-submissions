class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[] max1 = new int[nums.length-1];
        int[] max2 = new int[nums.length-1];

        max1[0] = nums[0];
        max2[0] = nums[1];
        max1[1] = Math.max(nums[0], nums[1]);
        max2[1] = Math.max(nums[1], nums[2]);

        for(int i = 2; i < nums.length - 1; i++ ){
            max1[i] = Math.max(max1[i-2] + nums[i], max1[i-1]);
            max2[i] = Math.max(max2[i-2] + nums[i+1], max2[i-1]);
        }

        return Math.max(max1[nums.length-2], max2[nums.length-2]);
    }
}
