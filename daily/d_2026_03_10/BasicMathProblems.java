package DSA_Diary.daily.d_2026_03_10;/*
BASIC MATH PROBLEMS (COMMONLY ASKED IN DSA / LEETCODE)

This file contains implementations of several basic math problems:
1. Count digits in a number
2. Reverse an integer
3. Check palindrome number
4. Check if number is Armstrong
5. Find GCD / HCF
6. Check if number is prime
7. Print all divisors
8. Check if number is perfect number

All implementations avoid unnecessary space and use optimal approaches.
*/

import java.util.*;

class BasicMathProblems {

    public static void main(String[] args) {

        int n = 12321;

        System.out.println("Digits: " + countDigits(n));
        System.out.println("Reverse: " + reverseNumber(123));
        System.out.println("Palindrome: " + isPalindrome(121));
        System.out.println("Armstrong: " + isArmstrong(153));
        System.out.println("GCD: " + gcd(48, 18));
        System.out.println("Prime: " + isPrime(29));
        System.out.println("Divisors: " + getDivisors(36));
        System.out.println("Perfect Number: " + isPerfect(28));
    }


    /*
    ------------------------------------------------------------
    1. COUNT DIGITS IN A NUMBER
    ------------------------------------------------------------
    Problem:
    Given an integer n, return the number of digits in the number.

    Example:
    Input: 12345
    Output: 5

    Approach:
    Use logarithmic formula:
    digits = floor(log10(n)) + 1

    Time Complexity: O(1)
    Space Complexity: O(1)
    */
    static int countDigits(int n) {
        if (n == 0) return 1;
        return (int)(Math.log10(n) + 1);
    }



    /*
    ------------------------------------------------------------
    2. REVERSE INTEGER
    ------------------------------------------------------------
    Problem:
    Reverse digits of an integer. If overflow occurs return 0.

    Example:
    Input: 123
    Output: 321

    Time Complexity: O(log10 n)
    Space Complexity: O(1)
    */
    static int reverseNumber(int x) {

        int rev = 0;

        while (x != 0) {

            int digit = x % 10;
            x /= 10;

            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10)
                return 0;

            rev = rev * 10 + digit;
        }

        return rev;
    }



    /*
    ------------------------------------------------------------
    3. PALINDROME NUMBER
    ------------------------------------------------------------
    Problem:
    Check whether a number reads same forward and backward.

    Example:
    Input: 121
    Output: true

    Approach:
    Reverse the number and compare with original.

    Time Complexity: O(log10 n)
    Space Complexity: O(1)
    */
    static boolean isPalindrome(int x) {

        if (x < 0) return false;

        int original = x;
        int rev = 0;

        while (x != 0) {

            int digit = x % 10;
            rev = rev * 10 + digit;
            x /= 10;
        }

        return original == rev;
    }



    /*
    ------------------------------------------------------------
    4. ARMSTRONG NUMBER
    ------------------------------------------------------------
    Problem:
    A number is Armstrong if sum of each digit^number_of_digits
    equals the number.

    Example:
    153
    1³ + 5³ + 3³ = 153

    Time Complexity: O(log10 n)
    Space Complexity: O(1)
    */
    static boolean isArmstrong(int n) {

        int digits = countDigits(n);
        int sum = 0;
        int temp = n;

        while (temp != 0) {

            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }

        return sum == n;
    }



    /*
    ------------------------------------------------------------
    5. GCD / HCF USING EUCLID ALGORITHM
    ------------------------------------------------------------
    Problem:
    Find greatest common divisor of two numbers.

    Example:
    gcd(48,18) = 6

    Time Complexity: O(log(min(a,b)))
    Space Complexity: O(1)
    */
    static int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }



    /*
    ------------------------------------------------------------
    6. CHECK PRIME NUMBER
    ------------------------------------------------------------
    Problem:
    Check if a number is prime.

    Example:
    Input: 29
    Output: true

    Approach:
    Check divisibility up to sqrt(n)

    Time Complexity: O(√n)
    Space Complexity: O(1)
    */
    static boolean isPrime(int n) {

        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0)
                return false;
        }

        return true;
    }



    /*
    ------------------------------------------------------------
    7. FIND ALL DIVISORS
    ------------------------------------------------------------
    Problem:
    Print all divisors of a number.

    Example:
    Input: 36
    Output: [1,2,3,4,6,9,12,18,36]

    Time Complexity: O(√n)
    Space Complexity: O(n)
    */
    static List<Integer> getDivisors(int n) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {

            if (n % i == 0) {

                list.add(i);

                if (i != n / i)
                    list.add(n / i);
            }
        }

        Collections.sort(list);
        return list;
    }



    /*
    ------------------------------------------------------------
    8. PERFECT NUMBER
    ------------------------------------------------------------
    Problem:
    A number is perfect if sum of its proper divisors
    equals the number.

    Example:
    28
    divisors = 1 + 2 + 4 + 7 + 14 = 28

    Time Complexity: O(√n)
    Space Complexity: O(1)
    */
    static boolean isPerfect(int n) {

        int sum = 1;

        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {

                sum += i;

                if (i != n / i)
                    sum += n / i;
            }
        }

        return sum == n && n != 1;
    }
}