class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = this.getMax(piles);
        int l = 1;
        int rate = l + (r-l)/2;
        int minRate = rate;
        while (l<=r) {
            int sum = this.getHours(piles, rate);
            if (sum > h ) {
                l = rate + 1;
                rate = l + (r-l)/2; 
            } else {
                minRate = rate;
                r = rate - 1;
                rate = l + (r-l)/2; 
            }
        }

        return minRate;
    }

    private int getHours(int[] piles, int rate) {
        int sum = 0;
        for(int i : piles)
            sum += (int) Math.ceil((i * 1.0 ) / rate );
        
        return sum;
    }

    private int getMax(int[] arr) {
        int max = arr[0];

        for(int i = 1; i < arr.length ; i++)
            max = Math.max(max, arr[i]);
        return max;
    }

    private int getMin(int[] arr) {
        int min = arr[0];

        for(int i = 1; i < arr.length ; i++)
            min = Math.min(min, arr[i]);
        return min;
    }

}
