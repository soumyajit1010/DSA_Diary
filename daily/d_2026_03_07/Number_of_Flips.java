package DSA_Diary.daily.d_2026_03_07;/*
LeetCode 1888
Minimum Number of Flips to Make the Binary String Alternating

Approach:
1. Double the string (simulate rotations)
2. Create two alternating patterns:
   010101...
   101010...
3. Use sliding window of size n
4. Track mismatch counts
*/

class Number_of_Flips {
    public int minFlips(String s) {

        int n = s.length();
        String str = s + s;

        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();

        for(int i = 0; i < 2*n; i++){
            alt1.append(i % 2 == 0 ? '0' : '1');
            alt2.append(i % 2 == 0 ? '1' : '0');
        }

        int diff1 = 0, diff2 = 0;
        int res = Integer.MAX_VALUE;

        int left = 0;

        for(int right = 0; right < 2*n; right++){

            if(str.charAt(right) != alt1.charAt(right)) diff1++;
            if(str.charAt(right) != alt2.charAt(right)) diff2++;

            if(right - left + 1 > n){
                if(str.charAt(left) != alt1.charAt(left)) diff1--;
                if(str.charAt(left) != alt2.charAt(left)) diff2--;
                left++;
            }

            if(right - left + 1 == n){
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }

        return res;
    }
}