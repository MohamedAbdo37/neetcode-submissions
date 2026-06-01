class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] nums = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            nums[i] = target - numbers[i];
        }

        int i = 0;
        int j = numbers.length - 1;

        while (i != j) {
            if (numbers[i] > nums[j])
                j--;
            else if (numbers[i] < nums[j])
                i++;
            else
                break;
        }

        return new int[] { i + 1, j + 1 };
    }
}
