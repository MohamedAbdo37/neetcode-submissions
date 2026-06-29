class Solution {
    public int trap(int[] height) {

        if (height.length == 0) return 0;

        int[] l = new int[height.length];
        int[] r = new int[height.length];

        l[0] = 0;
        r[height.length-1] = 0;
        int max = 0;
        for(int i = 1; i < height.length; i++){
            max = Math.max(max, height[i-1]);
            l[i] = max;
        }
        
        max = 0;
        for(int i = height.length -2 ; i >-1 ; i--){
            max = Math.max(max, height[i+1]);
            r[i] = max;
        }


        int count = 0;
        for(int i = 0; i < height.length; i++) {
            int water =  Math.min(l[i], r[i]) - height[i];
            count += Math.max(0, water);
        }

        return count;
        
    }
}
