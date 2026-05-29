class Solution {
    private List<Integer> stack = new ArrayList<>();

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < result.length; i++) {
            if (this.stack.isEmpty()) {
                this.push(stack, i);
                continue;
            }
            if (temperatures[this.peek(stack)] < temperatures[i]) {
                result[this.peek(stack)] = i - this.peek(stack);
                this.pop(stack);
                i--;
            } else {
                this.push(stack, i);
            }
        }
        while (!this.stack.isEmpty()) {
            result[this.pop(stack)] = 0;
        }
        return result;
    }

    private int pop(List<Integer> stack) {
        return stack.remove(stack.size() - 1);
    }

    private void push(List<Integer> stack, int value) {
        stack.add(value);
    }

    private int peek(List<Integer> stack) {
        return stack.get(stack.size() - 1);
    }
}
