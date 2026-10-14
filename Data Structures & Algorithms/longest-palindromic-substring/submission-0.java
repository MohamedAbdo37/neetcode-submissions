class Solution {
    public String longestPalindrome(String s) {
        String max = "";

        for(int i = 0; i < s.length(); i++) 
            for(int j = i+1; j < s.length()+1; j++ ) {
                String sub = s.substring(i, j);
                if(isPalindrome(sub)) {
                    if(max.length() < (j-i))
                        max = sub;
                }
            }
        return max;
    }

    boolean isPalindrome(String s) {
        if(s.length() < 2)
            return true;
        
        for(int i = 0; i < s.length()/2 ; i ++){
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }

        return true;
    }
}
