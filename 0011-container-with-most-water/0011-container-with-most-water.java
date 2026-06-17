class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        int st = 0;
        int end = len - 1;
        while (st < end) {
            int length = Math.min(height[st], height[end]);
            int width = end - st;
            int area = length * width;
            max = Math.max(max, area);
            if (height[st] < height[end]) {
                st++;

            } else {
                end--;
            }
        }
        return max;

    }
}