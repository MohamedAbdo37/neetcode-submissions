class Solution {
    private final List<Integer> result = new ArrayList<>();

    public int evalRPN(String[] tokens) {
        for (String token : tokens) {
            if (!isOperation(token))
                this.result.add(Integer.valueOf(token));
            else {
                int prev = this.result.remove(this.result.size() - 1);
                switch (token) {
                    case "+":
                        this.result.add((prev + this.result.remove(this.result.size() - 1)));
                        break;
                    case "*":
                        this.result.add((prev * this.result.remove(this.result.size() - 1)));
                        break;
                    case "/":
                        if (prev == 0)
                            throw new Error();
                        else
                            this.result.add((this.result.remove(this.result.size() - 1) / prev));
                        break;
                    case "-":
                        if (this.result.isEmpty())
                            this.result.add(-prev);
                        else
                            this.result.add((this.result.remove(this.result.size() - 1) - prev));
                        break;
                    default:
                        throw new AssertionError();
                }

            }
        }
        return this.result.get(0);
    }

    private boolean isOperation(String op) {
        return switch (op) {
            case "+", "-", "*", "/" -> true;
            default -> false;
        };
    }
}
