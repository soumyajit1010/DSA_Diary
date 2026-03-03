package DSA_Diary.daily.d_2026_03_03;

class Solution {
    public char findKthBit(int n, int k) {

        // Base case
        if (n == 1) return '0';

        int length = (1 << n) - 1;   // 2^n - 1
        int mid = (length + 1) / 2;  // 2^(n-1)

        // If k is middle
        if (k == mid) return '1';

        // If k is in left half
        if (k < mid)
            return findKthBit(n - 1, k);

        // If k is in right half
        // Find mirrored position
        char bit = findKthBit(n - 1, length - k + 1);

        // Invert it
        return bit == '0' ? '1' : '0';
    }
/*
    public String generateString(int n) {

        String s = "0";

        for (int i = 2; i <= n; i++) {
            String inverted = invert(s);
            String reversed = new StringBuilder(inverted).reverse().toString();
            s = s + "1" + reversed;
        }

        return s;
    }

    private String invert(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == '0') sb.append('1');
            else sb.append('0');
        }

        return sb.toString();
    }

 */
}