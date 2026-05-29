class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       int[] answer = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums)
            if (map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i, 1);


        for (int j = 0; j < k; j++) {
            int max = 0;
            for (int i : map.keySet()) {
                if(max < map.get(i)) {
                    max = map.get(i);
                    answer[j] = i;
                }

            }
           map.remove(answer[j]);
        }


        return answer;
    }
}
