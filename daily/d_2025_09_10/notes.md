# 📒 Notes for 2025-09-10

## ✅ Topic Covered
**Subsequences with Sum = K (Recursion + Backtracking)**

---

## 🔹 Problems Practiced
1. **Printing all subsequences whose sum = K**
    - Explored all subsequences using recursion (include/exclude approach).
    - Collected valid subsequences in a result list.

2. **Printing any ONE subsequence whose sum = K**
    - Similar approach, but stopped recursion once the first valid subsequence was found.
    - Optimized compared to the "print all" version.

3. **Counting subsequences whose sum = K**
    - Did not store subsequences, only counted them.
    - More space-efficient.

---

## 🧠 Key Learnings
- **Recursion Choices**: At each index → Pick or Not Pick.
- **Base Case**:
    - If index == n:
        - Check if sum == K.
- **Backtracking**: Important when storing subsequences (`add → recurse → remove`).
- **Optimization**: Stop recursion early if only one subsequence is required.
- **Complexity**:
    - Time → O(2^n), since each element has 2 choices.
    - Space → O(n) recursion stack depth.

---

## ⚡ Lecture Reference
- Learned from [take U forward (Striver) - Recursion Lecture(L7)](https://youtu.be/eQCS_v3bw0Q?si=dEyxs7s4jPp1uiOv)

---

## 📌 Extra Notes
- This problem is a **subset of Subset Sum problems** (can extend to DP later).
- Variations learned today:
    - Print All
    - Print One
    - Count Total
- Helps in building the foundation for **Dynamic Programming (DP)**.

