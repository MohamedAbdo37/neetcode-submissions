class Solution {
    private final Set<Integer> seqs = new HashSet<>();

    public int longestConsecutive(int[] nums) {
        int longest = 0;
        for (int num : nums)
            this.seqs.add(num);

        for (int num : nums) {
            if (!this.seqs.contains(num - 1)) {
                int seq = 1;
                while (this.seqs.contains(num + 1)) {
                    seq++;
                    num++;
                }
                if (seq > longest)
                    longest = seq;
            }
        }

        return longest;
    }
}
