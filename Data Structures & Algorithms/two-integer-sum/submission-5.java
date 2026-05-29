class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];

        Set<Integer> set = new HashSet<>();
        int edge = -1;
        int i = 0;
        for (; i < nums.length; i++) {
            if(set.contains(target-nums[i])){
                indexes[1] = i;
                edge = target - nums[i];
                break;
            } else
                set.add(nums[i]);
        }

        i = 0;
        while (i < indexes[1]){
            if( nums[i] == edge){
                indexes[0] = i;
                break;
            }
            else i++;
        }

        return indexes;
    }
}
