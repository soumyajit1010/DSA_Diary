package DSA_Diary.daily.d_2026_02_26;
import java.util.*;

/*
160. Intersection of Two Linked Lists
Difficulty: Easy

Given the heads of two singly linked lists headA and headB,
return the node at which the two lists intersect.
If no intersection exists, return null.

IMPORTANT:
- Intersection means same node reference (same memory),
  NOT same value.
- Lists must retain original structure.

------------------------------------------------------------

Example 1:
A: 4 -> 1 -> 8 -> 4 -> 5
B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
Intersection at node with value 8

Example 2:
A: 1 -> 9 -> 1 -> 2 -> 4
B: 3 -> 2 -> 4
Intersection at node with value 2

Example 3:
A: 2 -> 6 -> 4
B: 1 -> 5
No intersection

------------------------------------------------------------

Definition:
------------------------------------------------------------
*/
class ListNode {
    int val;
    ListNode next;
}



public class Intersection_of_Two_Linked_Lists {

    // =========================================================
    // METHOD 1: Length Difference Method
    // =========================================================
    /*
    Idea:
    1. Calculate length of both lists.
    2. Move the longer list pointer ahead by length difference.
    3. Move both pointers together.
    4. First common node is intersection.

    Time Complexity: O(n + m)
    Space Complexity: O(1)
    */

    public ListNode getIntersectionNode_Length(ListNode headA, ListNode headB) {

        int lenA = 0, lenB = 0;

        ListNode t1 = headA;
        ListNode t2 = headB;

        while (t1 != null) {
            lenA++;
            t1 = t1.next;
        }

        while (t2 != null) {
            lenB++;
            t2 = t2.next;
        }

        t1 = headA;
        t2 = headB;

        // Align both pointers
        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff-- > 0) t1 = t1.next;
        } else {
            int diff = lenB - lenA;
            while (diff-- > 0) t2 = t2.next;
        }

        // Traverse together
        while (t1 != null && t2 != null) {
            if (t1 == t2) return t1;
            t1 = t1.next;
            t2 = t2.next;
        }

        return null;
    }


    // =========================================================
    // METHOD 2: Two Pointer Switching (Most Optimal)
    // =========================================================
    /*
    Idea:
    - Traverse both lists.
    - When pointer reaches null, switch to other list head.
    - Eventually both pointers will meet at intersection
      or both become null.

    Why it works:
    - Each pointer travels lengthA + lengthB.
    - They align automatically.

    Time Complexity: O(n + m)
    Space Complexity: O(1)
    */

    public ListNode getIntersectionNode_TwoPointer(ListNode headA, ListNode headB) {

        if(headA==null || headB==null)return null;

        ListNode t1=headA;
        ListNode t2=headB;

        while(t1!=t2){
            t1=t1.next;
            t2=t2.next;
            if(t1==t2) return t1;
            if(t1==null) t1=headB;
            if(t2==null) t2=headA;
        }
        return t1; // either intersection or null
    }


    // =========================================================
    // METHOD 3: Using HashSet
    // =========================================================
    /*
    Idea:
    - Store all nodes of list A in HashSet.
    - Traverse list B.
    - First node already in set is intersection.

    Time Complexity: O(n + m)
    Space Complexity: O(n)
    */

    public ListNode getIntersectionNode_HashSet(ListNode headA, ListNode headB) {

        HashSet<ListNode> set = new HashSet<>();

        ListNode temp = headA;

        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }

        temp = headB;

        while (temp != null) {
            if (set.contains(temp))
                return temp;
            temp = temp.next;
        }

        return null;
    }
}

