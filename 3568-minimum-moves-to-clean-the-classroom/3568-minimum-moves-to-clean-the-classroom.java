

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        // litterId[i][j] = bit number assigned to litter at (i, j)
        int[][] litterId = new int[m][n];

        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        int startR = 0;
        int startC = 0;
        int litterCount = 0;

        // Find starting position and assign IDs to litter cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startR = i;
                    startC = j;
                }

                if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        // No litter
        if (litterCount == 0) {
            return 0;
        }

        /*
         * If there are k litter cells:
         *
         * 0 -> all collected
         * (1 << k) - 1 -> all uncollected
         */
        int fullMask = (1 << litterCount) - 1;

        /*
         * visited[row][col][energy][mask]
         */
        boolean[][][][] visited =
                new boolean[m][n][energy + 1][1 << litterCount];

        /*
         * state = {row, col, remainingEnergy, mask}
         */
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{
                startR,
                startC,
                energy,
                fullMask
        });

        visited[startR][startC][energy][fullMask] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level
            while (size-- > 0) {

                int[] state = queue.poll();

                int r = state[0];
                int c = state[1];
                int currentEnergy = state[2];
                int mask = state[3];

                // All litter collected
                if (mask == 0) {
                    return moves;
                }

                // No energy means no further movement
                if (currentEnergy == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // Outside grid
                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    char nextCell = classroom[nr].charAt(nc);

                    /*
                     * Every movement costs 1 energy.
                     * If we enter R, energy is immediately
                     * restored to maximum.
                     */
                    int nextEnergy;

                    if (nextCell == 'R') {
                        nextEnergy = energy;
                    } else {
                        nextEnergy = currentEnergy - 1;
                    }

                    int nextMask = mask;

                    // Collect litter
                    if (nextCell == 'L') {
                        int id = litterId[nr][nc];

                        // Mark this litter as collected
                        nextMask &= ~(1 << id);
                    }

                    // Avoid revisiting identical states
                    if (!visited[nr][nc][nextEnergy][nextMask]) {

                        visited[nr][nc][nextEnergy][nextMask] = true;

                        queue.offer(new int[]{
                                nr,
                                nc,
                                nextEnergy,
                                nextMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}
