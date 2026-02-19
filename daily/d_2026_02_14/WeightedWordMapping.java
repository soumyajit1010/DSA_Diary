package DSA_Diary.daily.d_2026_02_14;
/*
Q1. Weighted Word Mapping

You are given:
1. An array of strings words, where each string contains lowercase English letters.
2. An integer array weights of length 26,
   where weights[i] represents the weight of the ith lowercase English letter.

Task:
1. Find the weight of each word (sum of weights of its characters).
2. Take the result modulo 26.
3. Map the result using reverse alphabetical order:
      0 -> 'z'
      1 -> 'y'
      2 -> 'x'
      ...
      25 -> 'a'
4. Return a string formed by concatenating mapped characters
   for all words in order.

Example:
Input:
words = ["abcd","def","xyz"]

Output:
"rij"
*/
public class WeightedWordMapping {
    public String weightedWordMapping(String[] words, int[] weights) {

        // StringBuilder to store final answer
        StringBuilder result = new StringBuilder();

        // Traverse each word
        for (int i = 0; i < words.length; i++) {

            int sum = 0;

            // Traverse each character of the current word
            for (int j = 0; j < words[i].length(); j++) {

                char ch = words[i].charAt(j);

                // Get index of character (0-25)
                int index = ch - 'a';

                // Add weight of that character
                sum += weights[index];
            }

            // Take modulo 26
            int mod = sum % 26;

            // Reverse alphabetical mapping
            char mappedChar = (char) ('z' - mod);

            // Append to result
            result.append(mappedChar);
        }

        return result.toString();
    }
}

/*
Time Complexity:
Let n = number of words
Let m = average length of each word

We traverse every character of every word.

Time Complexity = O(n × m)

Space Complexity:
We use StringBuilder to store result of size n.

Space Complexity = O(n)
*/

