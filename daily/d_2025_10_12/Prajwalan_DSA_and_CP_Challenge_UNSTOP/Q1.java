package DSA_Diary.daily.d_2025_10_12.Prajwalan_DSA_and_CP_Challenge_UNSTOP;
import java.util.*;

public class Q1 {
}

/*
📘 Problem Statement
---------------------------------------------------
A software company has three editions of its product released in chronological order:
Nimbus < Stratus < Cirrus

Given two editions, E1 and E2, determine whether E1 is the same as or a newer edition than E2.

---------------------------------------------------
🔹 Input Format:
The input consists of a single line containing two space-separated strings: E1 and E2.

Here, E1 and E2 are guaranteed to be one of the editions:
{ "Nimbus", "Stratus", "Cirrus" }.

🔹 Output Format:
Print "Yes" if E1 is the same as or newer than E2, otherwise print "No".

---------------------------------------------------
🔹 Sample Test Case 1:
Input:
Stratus Nimbus

Output:
Yes
(Explanation: Stratus comes after Nimbus, so it is newer.)

🔹 Sample Test Case 2:
Input:
Stratus Cirrus

Output:
No
(Explanation: Stratus comes before Cirrus, so it is not newer.)
---------------------------------------------------
✅ Approach:
1. Assign each edition a numeric order:
   Nimbus → 1
   Stratus → 2
   Cirrus → 3

2. Compare the numeric values of E1 and E2:
   - If E1’s value ≥ E2’s value → print "Yes"
   - Otherwise → print "No"

---------------------------------------------------
⏱️ Time Complexity: O(1)
🧠 Space Complexity: O(1)
---------------------------------------------------
*/


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String E1 = sc.next();
        String E2 = sc.next();

        // Map each edition to its release order
        Map<String, Integer> order = new HashMap<>();
        order.put("Nimbus", 1);
        order.put("Stratus", 2);
        order.put("Cirrus", 3);

        // Compare based on their numeric order
        if (order.get(E1) >= order.get(E2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

