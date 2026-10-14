class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] min = new int[cost.length];
        min[0] = cost[0];
        min[1] = cost[1];

        for(int i = 2; i < cost.length; i++) {
            min[i] = cost[i] + Math.min(min[i-1], min[i-2]);
        }

        return Math.min(min[cost.length-1], min[cost.length-2]);
    }
}
