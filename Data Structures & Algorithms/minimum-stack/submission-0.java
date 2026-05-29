class MinStack {
    
    private List<Integer> stack;
    private List<Integer> minis;

    public MinStack() {
        this.stack = new ArrayList<Integer>();
        this.minis = new ArrayList<>();
    }

    public void push(int val) {
        this.stack.add(val);
        if (minis.isEmpty())
            this.minis.add(val);
        else {
            for (int i = this.minis.size() - 1; i > -1; i--) {
                if (val <= this.minis.get(i)) {
                    this.minis.add(i + 1, val);
                    break;
                }
            }
        }
    }

    public void pop() {
        int val = this.stack.remove(this.stack.size() - 1);
        for (int i = this.minis.size() - 1; i > -1; i--) {
            if (val == this.minis.get(i)) {
                this.minis.remove(i);
                break;
            }
        }
    }

    public int top() {
        return this.stack.get(stack.size() - 1);
    }

    public int getMin() {
        return this.minis.get(this.minis.size() - 1);
    }
}
