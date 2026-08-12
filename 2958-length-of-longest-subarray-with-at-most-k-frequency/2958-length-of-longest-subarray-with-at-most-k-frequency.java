class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        int left = 0;
        int maxSub = 0;

        for (int right = 0; right < nums.length; right++) {

            int ele = nums[right];

            if (hm.get(ele) != null) {
                hm.put(ele, hm.get(ele) + 1);
            } else {
                hm.put(ele, 1);
            }

            while (hm.get(ele) > k) {

                int leftEle = nums[left];

                hm.put(leftEle, hm.get(leftEle) - 1);

                left++;
            }

            int length = right - left + 1;

            if (maxSub < length) {
                maxSub = length;
            }
        }

        return maxSub;
    }
}