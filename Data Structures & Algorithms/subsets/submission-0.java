class Solution {

    private List<Integer> sol;
    private List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
       this.sol = new ArrayList<>();
       this.res = new ArrayList<>();

       this.backtrack(0, nums);

       return this.res;
    }

    private void backtrack(int i, int[] nums) {
        if (i == nums.length) {
            this.res.add(List.copyOf(this.sol));
            return;
        }

        backtrack(i+1, nums);

        this.sol.add(nums[i]);
        backtrack(i+1, nums);
        this.sol.remove(this.sol.size() - 1);

    }
}
