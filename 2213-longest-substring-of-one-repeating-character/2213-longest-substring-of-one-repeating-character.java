class Solution {

    class Node {
        int len;
        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int best;

        Node(int len, char leftChar, char rightChar,
             int prefix, int suffix, int best) {

            this.len = len;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.prefix = prefix;
            this.suffix = suffix;
            this.best = best;
        }
    }

    Node[] tree;
    String s;

    // Merge two nodes
    Node merge(Node left, Node right) {

        Node res = new Node(
            left.len + right.len,
            left.leftChar,
            right.rightChar,
            0,
            0,
            0
        );

        // Prefix
        res.prefix = left.prefix;

        if (left.prefix == left.len &&
            left.rightChar == right.leftChar) {

            res.prefix = left.len + right.prefix;
        }

        // Suffix
        res.suffix = right.suffix;

        if (right.suffix == right.len &&
            left.rightChar == right.leftChar) {

            res.suffix = right.len + left.suffix;
        }

        // Best answer
        res.best = Math.max(left.best, right.best);

        // Substring crossing the middle
        if (left.rightChar == right.leftChar) {

            res.best = Math.max(
                res.best,
                left.suffix + right.prefix
            );
        }

        return res;
    }

    // Build Segment Tree
    void build(int node, int start, int end) {

        if (start == end) {

            char c = s.charAt(start);

            tree[node] = new Node(
                1,
                c,
                c,
                1,
                1,
                1
            );

            return;
        }

        int mid = start + (end - start) / 2;

        build(node * 2, start, mid);

        build(node * 2 + 1, mid + 1, end);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    // Point Update
    void update(int node, int start, int end,
                int index, char c) {

        if (start == end) {

            tree[node] = new Node(
                1,
                c,
                c,
                1,
                1,
                1
            );

            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {

            update(
                node * 2,
                start,
                mid,
                index,
                c
            );

        } else {

            update(
                node * 2 + 1,
                mid + 1,
                end,
                index,
                c
            );
        }

        // Recalculate current node
        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    public int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices) {

        this.s = s;

        int n = s.length();

        tree = new Node[4 * n];

        // Build initial tree
        build(1, 0, n - 1);

        int q = queryIndices.length;

        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {

            int index = queryIndices[i];

            char c = queryCharacters.charAt(i);

            // Update character
            update(
                1,
                0,
                n - 1,
                index,
                c
            );

            // Root contains complete answer
            ans[i] = tree[1].best;
        }

        return ans;
    }
}