class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int wSize = s1.length();

        Map<Character, Integer> st = new HashMap<>();

        for (char c : s1.toCharArray()) {
            if (st.containsKey(c))
                st.put(c, st.get(c) + 1);
            else
                st.put(c, 1);
        }

        int l = 0;
        char c;
        for (int r = 0; r < s2.length(); r++) {
            c = s2.charAt(r);
            if (st.containsKey(c))
                st.put(c, st.get(c) - 1);

            if ((r - l) + 1 == wSize) {
                if (this.isClusion(st))
                    return true;
                c = s2.charAt(l);
                if (st.containsKey(c))
                    st.put(c, st.get(c) + 1);
                l++;
            }

        }
        return false;
    }

    private boolean isClusion(Map<Character, Integer> m) {
        for (char c : m.keySet())
            if (m.get(c) != 0)
                return false;

        return true;
    }
}
