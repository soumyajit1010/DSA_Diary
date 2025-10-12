package DSA_Diary.daily.d_2025_10_12.Prajwalan_DSA_and_CP_Challenge_UNSTOP;

/*
Problem Statement:

You are given N distinct points on a 2D grid.
No two points overlap, and no three of them are on the same straight line.
The i-th point has coordinates (Xi, Yi).

Your task is to determine how many unique sets of four points can be chosen such that
those four points can form a valid quadrilateral having at least one pair of opposite sides parallel.

Rectangles, parallelograms, and trapezoids satisfy this condition.

--------------------------------------------------------------
Example:

Input:
5
0 2
0 5
1 0
2 1
2 4

Output:
3

Explanation:
The 3 quadrilaterals that satisfy the condition are:
1. Points (0,2), (2,4), (2,1), (1,0)
2. Points (0,2), (1,0), (2,1), (0,5)
3. Points (0,2), (0,5), (2,4), (2,1)

--------------------------------------------------------------
Input Format:
N
X1 Y1
X2 Y2
...
XN YN

Output Format:
Print a single integer — the total number of 4-point combinations that can form
a quadrilateral with at least one pair of opposite sides parallel.

--------------------------------------------------------------
Constraints:
4 ≤ N ≤ 2000
0 ≤ Xi, Yi ≤ 10^7
All coordinates are integers.
No two points coincide.
No three points are collinear.

--------------------------------------------------------------
Sample Testcase 1:
Input:
5
0 2
0 5
1 0
2 1
2 4

Output:
3

Sample Testcase 2:
Input:
8
0 1
1 3
2 3
3 1
0 2
1 0
2 0
3 2

Output:
22
*/

import java.util.*;

 class ParallelSidesQuadrilateral {
    static class Slope {
        long dx, dy;
        Slope(long dx, long dy) {
            long g = gcd(Math.abs(dx), Math.abs(dy));
            if (g != 0) {
                dx /= g;
                dy /= g;
            }
            // Normalize sign to ensure uniqueness
            if (dx < 0 || (dx == 0 && dy < 0)) {
                dx = -dx;
                dy = -dy;
            }
            this.dx = dx;
            this.dy = dy;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Slope)) return false;
            Slope s = (Slope) o;
            return dx == s.dx && dy == s.dy;
        }

        @Override
        public int hashCode() {
            return Objects.hash(dx, dy);
        }
    }

    // Helper function to find GCD
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] x = new long[n];
        long[] y = new long[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextLong();
            y[i] = sc.nextLong();
        }

        // Map to store slope → count of point pairs with that slope
        Map<Slope, Integer> slopeMap = new HashMap<>();

        // Step 1: For every pair of points, compute slope
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long dx = x[j] - x[i];
                long dy = y[j] - y[i];
                Slope s = new Slope(dx, dy);
                slopeMap.put(s, slopeMap.getOrDefault(s, 0) + 1);
            }
        }

        // Step 2: For each slope, count possible parallelograms
        long result = 0;
        for (int count : slopeMap.values()) {
            if (count >= 2) {
                // Choose 2 pairs that have same slope → form quadrilateral with opposite sides parallel
                result += (long) count * (count - 1) / 2;
            }
        }

        System.out.println(result);
        sc.close();
    }
}

/*
🧠 Explanation:
- Each pair of points defines a line segment → we calculate its slope.
- Two line segments are parallel if they share the same slope.
- For each slope with `count` line segments, we can form C(count, 2) = count * (count - 1) / 2 quadrilaterals.

For example:
If 4 pairs of points have the same slope → we can choose 2 of them to form opposite sides → 6 quadrilaterals.

--------------------------------------------------------------
⏱️ Time Complexity:
O(N²)
→ We calculate slopes for all pairs of N points.
→ Then iterate over slopeMap once.

💾 Space Complexity:
O(N²)
→ At most, each unique slope can be stored in the HashMap (for large N).

--------------------------------------------------------------
✅ Efficient and works for up to N = 2000 (≈ 2 million pairs).
*/


public class Q5 {
}
