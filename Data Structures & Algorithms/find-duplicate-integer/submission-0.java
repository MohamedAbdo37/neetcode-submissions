class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> n = new HashSet<>();

        for(int i : nums) {
            if (n.contains(i)) 
                return i;
            n.add(i);
        }

        return 0;
    }
}
