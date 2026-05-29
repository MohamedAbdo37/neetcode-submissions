class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();

        Set<Integer> skipList = new HashSet<>();

        for (int i = 0; i < strs.length; i++) {
            if(skipList.contains(i))
                continue;
            List<String> sup = new ArrayList<>();
            sup.add(strs[i]);
            for (int j = i+1; j < strs.length ; j++) {
                if(this.isAnagram(strs[i], strs[j])) {
                    sup.add(strs[j]);
                    skipList.add(j);
                }
            }
            answer.add(sup);
        }


        return answer;
    }

    private boolean isAnagram(String s, String t){
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray())
            if(map.containsKey(c))  map.put(c, map.get(c) +1);
            else map.put(c, 1);

        for(char c : t.toCharArray())
            if(map.containsKey(c)){
                if( map.get(c) > 1) map.put(c, map.get(c)-1);
                else map.remove(c);
            } else return false;

        if(!map.isEmpty()) return false;

        return true;
    }
}
