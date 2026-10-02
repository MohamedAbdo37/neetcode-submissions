class Solution {
    private List<List<Integer>> solution;
    private List<Integer> options;
    private List<Integer> chosen;

    public List<List<Integer>> permute(int[] nums) {
        this.solution = new ArrayList<>();
        this.options = new ArrayList<>();
        for (int num : nums) {
            this.options.add(num);
        }

        this.backtrack();

        return solution;
    }

    private void backtrack() {
        if (this.options.isEmpty()) {
            this.solution.add(new ArrayList<>(this.chosen));
        }

        if (this.chosen == null)
            this.chosen = new ArrayList<>();

        for (int i = 0; i < this.options.size(); i++) {
            this.chosen.add(this.options.remove(i));
            this.backtrack();
            this.options.add(i, this.chosen.remove(this.chosen.size() - 1));
        }
    }
}
