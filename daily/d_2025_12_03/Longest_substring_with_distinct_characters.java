package DSA_Diary.daily.d_2025_12_03;

public class Longest_substring_with_distinct_characters {
    static int longestUniqueSubstr(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s.length();

        int res = 0;
        boolean[] vis = new boolean[26];

        // left and right pointer of sliding window
        int left = 0, right = 0;
        while (right < s.length()) {

            // If character is repeated, move left pointer marking
            // visited characters as false until the repeating
            // character is no longer part of the current window
            while (vis[s.charAt(right) - 'a'] == true) {
                vis[s.charAt(left) - 'a'] = false;
                left++;
            }

            vis[s.charAt(right) - 'a'] = true;

            // The length of the current window (right - left + 1)
            // is calculated and answer is updated accordingly.
            res = Math.max(res, (right - left + 1));
            right++;
        }
        return res;
    }

    

    static int longestUniqueSubstr2(String s){
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n; i++) {

            // Initializing all characters as not visited
            boolean[] vis = new boolean[26];

            for (int j = i; j < n; j++) {

                // If current character is visited
                // Break the loop
                if (vis[s.charAt(j) - 'a'] == true)
                    break;

                    // Else update the result if this window is
                    // larger, and mark current character as
                    // visited.
                else {
                    res = Math.max(res, j - i + 1);
                    vis[s.charAt(j) - 'a'] = true;
                }
            }
        }
        return res;
    }
}
