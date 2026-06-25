class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() < 2)
            return s.length();

        int maxString = 0;
        int[] A = new int[26];
        int r = 0, l = 0, W;

        for (; r < s.length(); r++) {
            W = (r - l) + 1;
            A[s.charAt(r) - 'A']++;
            for (; (W - this.maxChar(A) > k) && l < r; l++) {
                A[s.charAt(l) - 'A']--;
                W = (r - (l + 1)) + 1;
            }
            maxString = Math.max(maxString, W);
        }
        return maxString;
    }

    private int maxChar(int[] arr) {
        int max = -1;
        for (int a : arr) {
            max = Math.max(a, max);
        }

        return max;
    }
}
