package DSA_Diary.daily.d_2025_10_12.Prajwalan_DSA_and_CP_Challenge_UNSTOP;

/*
Problem Statement:

Two people, Alex and Blake, walk on a two-dimensional plane.

Alex starts at point (AX_start, AY_start) and walks straight toward (AX_goal, AY_goal) at speed 1.
Blake starts at point (BX_start, BY_start) and walks straight toward (BX_goal, BY_goal) at speed 1.

Both start walking simultaneously and stop when they reach their respective goals.
They may stop at different times.

Your task is to determine the minimum distance between Alex and Blake
— at any time (including while walking or after one/both stop).

--------------------------------------------------------------
Distance Formula:
For points (x1, y1) and (x2, y2):

d = sqrt((x1 - x2)^2 + (y1 - y2)^2)

--------------------------------------------------------------
Input Format:
The first line contains an integer T — the number of test cases.
Each test case consists of two lines:
AX_start AY_start AX_goal AY_goal BX_start BY_start BX_goal BY_goal

All coordinates are integers.

--------------------------------------------------------------
Output Format:
For each test case, print a single floating-point number —
the minimum distance between Alex and Blake.
Your answer will be considered correct if its absolute or relative error ≤ 10^-6.

--------------------------------------------------------------
Constraints:
1 ≤ T ≤ 2×10^5
-100 ≤ AX_start, AY_start, AX_goal, AY_goal, BX_start, BY_start, BX_goal, BY_goal ≤ 100
Start and goal points of each person are distinct.
All input values are integers.

--------------------------------------------------------------
Sample Input:
4
0 0 -2 2 -1 -1 4 4
0 0 20 0 60 80 10 11
-10 11 -8 9 -2 6 -10 -10
-10 -10 17 20 -17 20 20 17

Sample Output:
1.000000000000000
2.000000000000000
0.000000000033618
1.783905950993199
*/

import java.util.*;

 class MinDistanceBetweenWalkers {

    // Helper function to calculate distance between two points
    static double distance(double ax, double ay, double bx, double by) {
        double dx = ax - bx;
        double dy = ay - by;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Function to find minimum distance using ternary search
    static double minDistance(double ax1, double ay1, double ax2, double ay2,
                              double bx1, double by1, double bx2, double by2) {

        // Step 1: Calculate total path lengths for both
        double totalA = Math.sqrt((ax2 - ax1) * (ax2 - ax1) + (ay2 - ay1) * (ay2 - ay1));
        double totalB = Math.sqrt((bx2 - bx1) * (bx2 - bx1) + (by2 - by1) * (by2 - by1));

        // Step 2: Initialize time parameters
        double left = 0.0, right = Math.max(totalA, totalB);

        // Step 3: Ternary search for the minimum distance point
        for (int i = 0; i < 100; i++) {
            double t1 = left + (right - left) / 3;
            double t2 = right - (right - left) / 3;

            double ratioA1 = Math.min(t1 / totalA, 1.0);
            double ratioA2 = Math.min(t2 / totalA, 1.0);
            double ratioB1 = Math.min(t1 / totalB, 1.0);
            double ratioB2 = Math.min(t2 / totalB, 1.0);

            double ax_t1 = ax1 + (ax2 - ax1) * ratioA1;
            double ay_t1 = ay1 + (ay2 - ay1) * ratioA1;
            double bx_t1 = bx1 + (bx2 - bx1) * ratioB1;
            double by_t1 = by1 + (by2 - by1) * ratioB1;

            double ax_t2 = ax1 + (ax2 - ax1) * ratioA2;
            double ay_t2 = ay1 + (ay2 - ay1) * ratioA2;
            double bx_t2 = bx1 + (bx2 - bx1) * ratioB2;
            double by_t2 = by1 + (by2 - by1) * ratioB2;

            double dist1 = distance(ax_t1, ay_t1, bx_t1, by_t1);
            double dist2 = distance(ax_t2, ay_t2, bx_t2, by_t2);

            if (dist1 > dist2)
                left = t1;
            else
                right = t2;
        }

        // Step 4: Return final minimum distance
        double t = (left + right) / 2;
        double ratioA = Math.min(t / totalA, 1.0);
        double ratioB = Math.min(t / totalB, 1.0);
        double ax = ax1 + (ax2 - ax1) * ratioA;
        double ay = ay1 + (ay2 - ay1) * ratioA;
        double bx = bx1 + (bx2 - bx1) * ratioB;
        double by = by1 + (by2 - by1) * ratioB;

        return distance(ax, ay, bx, by);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            double ax1 = sc.nextDouble();
            double ay1 = sc.nextDouble();
            double ax2 = sc.nextDouble();
            double ay2 = sc.nextDouble();
            double bx1 = sc.nextDouble();
            double by1 = sc.nextDouble();
            double bx2 = sc.nextDouble();
            double by2 = sc.nextDouble();

            System.out.printf("%.15f\n", minDistance(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
        }

        sc.close();
    }
}

/*
🧠 Explanation:
- Each person moves linearly from start → goal at speed 1.
- Their position over time can be represented as a function of time (t).
- We use **ternary search** over time to minimize the distance function between both positions.
- The distance function is convex — so ternary search efficiently finds the minimum.

⏱️ Time Complexity:
O(T * log(precision))
→ Each test case runs ~100 iterations (constant time)
→ Overall complexity ≈ O(T)

💾 Space Complexity:
O(1)
→ Only a few double variables are used.
*/



public class Q4 {
}
