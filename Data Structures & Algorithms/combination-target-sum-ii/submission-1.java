class Solution {
    private int[] options;
    private List<List<Integer>> solutions;
    private List<Integer> solution;

     private void saveSolution() {
        this.solutions.add(new ArrayList<>(this.solution));
    }

    private void addValue(int value) {
        if (this.solution == null) {
            this.solution = new ArrayList<>();
            this.solution.add(value);
            return;
        }

        if (this.solution.isEmpty()) {
            this.solution.add(value);
            return;
        }

        for (int i = 0; i < this.solution.size(); i++) {
            if (this.solution.get(i) > value) {
                this.solution.add(i, value);
                return;
            }
        }

        this.solution.add(value);

    }

    private void remove(int value) {

        if (this.solution.size() == 1) {
            this.solution.clear();
            return;
        }

        for (int i = 0; i < this.solution.size() - 1; i++) {
            if (this.solution.get(i) == value && this.solution.get(i + 1) >= value) {
                this.solution.remove(i);
                return;
            }
        }

        if (this.solution.get(this.solution.size() - 1) == value)
            this.solution.remove(this.solution.size() - 1);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.options = candidates;
        Arrays.sort(this.options);
        this.solutions = new ArrayList<>();

        this.backtrack2(target, 0);

        return this.solutions;
    }

    private void backtrack2(int target, int start) {
        if (target < 0)
            return;

        if (target == 0) {
            this.saveSolution();
            return;
        }

        for (int i = start; i < options.length; i++) {
            if (i > start && options[i] == options[i - 1])
                continue;

            if (options[i] > target)
                break;
            this.addValue(options[i]);
            this.backtrack2(target - options[i], i + 1);
            this.remove(options[i]);
        }
    }
}
