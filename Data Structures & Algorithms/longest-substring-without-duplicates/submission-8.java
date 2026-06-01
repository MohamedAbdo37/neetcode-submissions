class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1)
            return 1;
        
        Set<Character> charsU = new HashSet<>();
        int maxString = 0;

        int start = 0;
        int end = 0;

         while (end < s.length()) {

            if (charsU.contains(s.charAt(end))) {
                maxString = Math.max(end - start, maxString);
                while (s.charAt(start) != s.charAt(end)) {
                    charsU.remove(s.charAt(start));
                    start++;
                }
                start++;
                // charsU.remove(s.charAt(start));
            } else {
                charsU.add(s.charAt(end));
            }
            end++;
        }

        return Math.max(maxString, charsU.size());
    }
}
