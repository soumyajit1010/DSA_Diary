package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Decimal_to_any_base_conversion;// Question:
// Decimal to any base conversion
// Difficulty: Basic
// Accuracy: 40.87%
// Submissions: 8K+
// Points: 1

// Given a decimal number N and the base B to which it should be converted.
// Convert the given number to the given base.

// Example 1:
// Input: B = 2, N = 12 
// Output: 1100
// Explanation: 12 in binary (base 2) = 1100

// Example 2:
// Input: B = 16, N = 282
// Output: 11A
// Explanation: 282 in hexadecimal (base 16) = 11A

// Expected Time Complexity: O(LogN)
// Expected Auxiliary Space: O(1)

class Solution {
    static String getNumber(int B, int N) {
        // String to store the result
        StringBuilder sb = new StringBuilder();

        // Characters for bases beyond 10
        char[] chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        // Loop to convert decimal to the desired base
        while (N > 0) {
            int remainder = N % B;
            sb.append(chars[remainder]);
            N /= B;
        }

        // Reverse the result because we've built it in reverse
        return sb.reverse().toString();
    }
}

/*
static String getNumber(int B, int N) {
    if (N == 0) return "0"; // handle zero case
    return convert(B, N);
}

private static String convert(int B, int N) {
    char[] chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    if (N == 0) return "";
    return convert(B, N / B) + chars[N % B];
}

 */