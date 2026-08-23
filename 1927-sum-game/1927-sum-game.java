class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        double sumDiff = 0;
        double qDiff = 0;

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                qDiff++;
            } else {
                sumDiff += num.charAt(i) - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                qDiff--;
            } else {
                sumDiff -= num.charAt(i) - '0';
            }
        }

        return sumDiff + (qDiff / 2.0) * 9 != 0;
    }
}