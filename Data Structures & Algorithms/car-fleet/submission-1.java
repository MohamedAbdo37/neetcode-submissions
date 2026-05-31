class Solution {
    class Fleet {
        int position;
        float steps;

        public Fleet(int position, int speed, int target) {
            this.position = position;
            if (speed != 0)
                this.steps = (target - position) / (float) speed;
            else
                this.steps = Float.MAX_VALUE;
        }
    }

    private final List<Fleet> fleets = new ArrayList<>();

    public int carFleet(int target, int[] position, int[] speed) {
        for (int i = 0; i < position.length; i++) {
            Fleet f = new Fleet(position[i], speed[i], target);
            this.push(f);
        }

        int fleetsCount = 0;
        Fleet top = this.pop();
        fleetsCount++;
        while (!this.fleets.isEmpty()) {
            if (isFleet(top, this.peek()))
                this.pop();
            else {
                top = this.pop();
                fleetsCount++;
            }
        }

        return fleetsCount;
    }

    private boolean isFleet(Fleet f1, Fleet f2) {
        return f1.steps >= f2.steps;
    }

    private Fleet pop() {
        return this.fleets.remove(this.fleets.size() - 1);
    }

    private void push(Fleet fleet) {
        if (this.fleets.isEmpty())
            this.fleets.add(fleet);
        else {
            for (int i = 0; i < this.fleets.size(); i++) {
                if (this.fleets.get(i).position > fleet.position) {
                    this.fleets.add(i, fleet);
                    return;
                }
            }
            this.fleets.add(fleet);
        }

    }

    private Fleet peek() {
        return this.fleets.get(this.fleets.size() - 1);
    }
}
