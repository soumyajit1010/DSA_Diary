package DSA_Diary.daily.d_2026_03_11;
/*
1009. Complement of Base 10 Integer

The complement of an integer is the integer you get when you flip all the 0's
to 1's and all the 1's to 0's in its binary representation.

For example:
5 in binary  = 101
Complement   = 010
Result       = 2

Given an integer n, return its complement.

Example 1:
Input: n = 5
Output: 2

Example 2:
Input: n = 7
Output: 0

Example 3:
Input: n = 10
Output: 5
*/

class Complement {

    /* =========================================================
       APPROACH 1 : String / Binary Conversion
       Convert number -> binary string
       Flip each bit
       Convert back to decimal
       Time Complexity  : O(log n)
       Space Complexity : O(log n)
    ========================================================= */

    public int complementUsingString(int n) {

        if(n == 0) return 1;

        String binary = Integer.toBinaryString(n);

        StringBuilder flipped = new StringBuilder();

        for(char c : binary.toCharArray()){
            if(c == '0') flipped.append('1');
            else flipped.append('0');
        }

        return Integer.parseInt(flipped.toString(),2);
    }


    /* =========================================================
       APPROACH 2 : Bit Mask + XOR
       Create a mask of all 1s having same number of bits as n.
       XOR with n to flip the bits.

       Example:
       n    = 5  -> 101
       mask = 7  -> 111
       XOR        010 -> 2

       Time Complexity  : O(log n)
       Space Complexity : O(1)
    ========================================================= */

    public int complementUsingMask(int n) {

        if(n == 0) return 1;

        int mask = 0;
        int temp = n;

        while(temp > 0){
            mask = (mask << 1) | 1;
            temp >>= 1;
        }

        return n ^ mask;
    }


    /* =========================================================
       APPROACH 3 : Using Highest One Bit (Shortest Optimized)
       Java provides highestOneBit() which gives the highest
       set bit in the number.

       mask = (highestOneBit << 1) - 1

       Time Complexity  : O(1)
       Space Complexity : O(1)
    ========================================================= */

    public int complementUsingBuiltin(int n) {

        if(n == 0) return 1;

        int mask = (Integer.highestOneBit(n) << 1) - 1;

        return n ^ mask;
    }
}
class test {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;

        String st = binary(n);
        return decimal(st);
    }

    public int decimal(String s){
        int res = 0;
        int power = 0;

        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == '1'){
                res += (1 << power);
            }
            power++;
        }

        return res;
    }

    public String binary(int n){

        StringBuilder sb = new StringBuilder();

        while(n > 0){
            int bit = n % 2;

            if(bit == 0) sb.append('1');
            else sb.append('0');

            n /= 2;
        }

        return sb.reverse().toString();
    }
}