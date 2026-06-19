class Solution {
    public int longestConsecutive(int[] nums) {
        int count = 1;
        int maxcount = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], 1);
        }
        for (int key : hm.keySet()) {
            if (!hm.containsKey(key - 1)) {
                while (hm.containsKey(key + 1)) {
                    key++;
                    count++;

                }
            }
            if (maxcount < count) {
                maxcount = count;
            }
            count = 1;

        }
        return maxcount;

    }
}