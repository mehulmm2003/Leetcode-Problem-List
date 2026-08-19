import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // Store reserved seats for each row
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(col);
        }

        // Rows with no reservations can fit 2 families
        int ans = (n - map.size()) * 2;

        // Process only rows having reservations
        for (int row : map.keySet()) {

            HashSet<Integer> seats = map.get(row);

            boolean left = !seats.contains(2)
                    && !seats.contains(3)
                    && !seats.contains(4)
                    && !seats.contains(5);

            boolean middle = !seats.contains(4)
                    && !seats.contains(5)
                    && !seats.contains(6)
                    && !seats.contains(7);

            boolean right = !seats.contains(6)
                    && !seats.contains(7)
                    && !seats.contains(8)
                    && !seats.contains(9);

            if (left && right) {
                ans += 2;
            } 
            else if (left || middle || right) {
                ans += 1;
            }
        }

        return ans;
    }
}