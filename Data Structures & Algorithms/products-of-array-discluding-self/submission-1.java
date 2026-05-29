class Solution {
    public int[] productExceptSelf(int[] nums) {
       if( nums.length < 3 )
            return new int[]{nums[1] , nums[0]};

        int [] output = nums.clone();

        for (int i = 1; i < nums.length; i++)
            nums[i] *= nums[i-1];
        

        for (int i = output.length-2; i > -1; i--)
            output[i] *= output[i+1];

        output[0] = output[1];

        for (int i = 1; i < (nums.length-1); i++)
            output[i] = nums[i-1] * output[i+1];

        output[nums.length-1] = nums[nums.length-2];

        return output;
    }
}  
