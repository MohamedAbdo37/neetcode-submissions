class Solution {
    private List<String> solutions;
    private int openOptions;
    private int closeOptions;
    private StringBuilder solutionBuilder;

    public List<String> generateParenthesis(int n) {
        this.solutions = new ArrayList<>();
        this.solutionBuilder = new StringBuilder();

        this.openOptions = n;
        this.closeOptions = 0;

        this.backtrack();

        return this.solutions;
    }

    private void backtrack() {

        if (this.openOptions == 0 && this.closeOptions == 0) {
            this.solutions.add(this.solutionBuilder.toString());
            return;
        }

        if (this.openOptions > 0) {
            this.solutionBuilder.append("(");
            this.openOptions--;
            this.closeOptions++;
            backtrack();
            this.openOptions++;
            this.closeOptions--;
            this.solutionBuilder.deleteCharAt(this.solutionBuilder.length() - 1);
        }

        if (this.closeOptions > 0) {
            this.solutionBuilder.append(")");
            this.closeOptions--;
            backtrack();
            this.closeOptions++;
            this.solutionBuilder.deleteCharAt(this.solutionBuilder.length() - 1);
        }
    }
}
