package DSA_Diary.daily.d_2025_11_30;

import java.util.ArrayList;

class Solution {
    public int maxDistinct(String s) {
        ArrayList<Character> arrayList = new ArrayList<>();
        arrayList.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (!arrayList.contains(s.charAt(i))){
                arrayList.add(s.charAt(i));
            }
        }

        return arrayList.size();
        
        
    }
}