class Solution {
    public boolean isHappy(int n) {
        return solve(n, new HashSet<>());
    }

    public boolean solve(int n, HashSet<Integer> set) {
        if (n == 1) return true;
        if (set.contains(n)) return false;

        set.add(n);

        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return solve(sum, set);
    }
}