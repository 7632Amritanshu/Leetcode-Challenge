class Solution {
    class Node {
        int maxLen;
        int prefixLen;
        int suffixLen;
        char leftChar;
        char rightChar;

        Node(char c) {
            this.maxLen = 1;
            this.prefixLen = 1;
            this.suffixLen = 1;
            this.leftChar = c;
            this.rightChar = c;
        }

        Node() {}
    }

    private Node[] tree;
    private char[] chars;
    private int n;

    private Node merge(Node left, Node right, int leftLen, int rightLen) {
        Node res = new Node();
        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;

        res.maxLen = Math.max(left.maxLen, right.maxLen);

        res.prefixLen = left.prefixLen;
        if (left.prefixLen == leftLen && left.rightChar == right.leftChar) {
            res.prefixLen = leftLen + right.prefixLen;
        }

        res.suffixLen = right.suffixLen;
        if (right.suffixLen == rightLen && left.rightChar == right.leftChar) {
            res.suffixLen = rightLen + left.suffixLen;
        }

        if (left.rightChar == right.leftChar) {
            res.maxLen = Math.max(res.maxLen, left.suffixLen + right.prefixLen);
        }

        return res;
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(chars[start]);
            return;
        }
        int mid = start + (end - start) / 2;
        int leftNode = 2 * node + 1;
        int rightNode = 2 * node + 2;

        build(leftNode, start, mid);
        build(rightNode, mid + 1, end);

        tree[node] = merge(tree[leftNode], tree[rightNode], mid - start + 1, end - mid);
    }

    private void update(int node, int start, int end, int idx, char ch) {
        if (start == end) {
            chars[idx] = ch;
            tree[node] = new Node(ch);
            return;
        }
        int mid = start + (end - start) / 2;
        int leftNode = 2 * node + 1;
        int rightNode = 2 * node + 2;

        if (idx <= mid) {
            update(leftNode, start, mid, idx, ch);
        } else {
            update(rightNode, mid + 1, end, idx, ch);
        }

        tree[node] = merge(tree[leftNode], tree[rightNode], mid - start + 1, end - mid);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        n = s.length();
        chars = s.toCharArray();
        tree = new Node[4 * n];

        build(0, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            update(0, 0, n - 1, idx, ch);
            ans[i] = tree[0].maxLen;
        }

        return ans;
    }
}