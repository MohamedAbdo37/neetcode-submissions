class Solution {
   private List<List<Integer>> solution;
    private List<Integer> subset;
    private int[] options;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.solution = new ArrayList<>();
        this.subset = new ArrayList<>();

        Arrays.sort(nums);
        this.options = nums;

        this.backtrack(0);

        return this.solution;
    }

    private void backtrack(int start) {

        this.solution.add(new ArrayList<>(subset));

        for (int i = start; i < options.length; i++) {
            if (i > start && this.options[i] == this.options[i - 1])
                continue;
            this.subset.add(options[i]);
            backtrack(i + 1);
            this.subset.remove(this.subset.size() - 1);
        }

    }
}
