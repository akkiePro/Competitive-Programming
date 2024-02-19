import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/valid-anagram/description/
 * @author Akash Prajapati
 */
public class ValidAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s");
        String s = sc.nextLine().toLowerCase();
        System.out.println("Enter t");
        String t = sc.nextLine().toLowerCase();

        Solution obj = new Solution();
        System.out.println(obj.isAnagram(s, t));
    }
}

/**
 * self solution
 */
/*class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        for (int i=0; i<s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    t = t.substring(0, j) + t.substring(j + 1);
                    if (t.isEmpty())
                        return true;

                    break;
                } else if (j == t.length()-1) {
                    return false;

                }
            }
        }
        return false;
    }
}*/

/**
 * optimised easy solution
 */
/*
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }
}*/

/**
 * Approach 2: Hash Table (Using HashMap)
 */
/*
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> count = new HashMap<>();

        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }

        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}*/

/**
 * Approach 3: Hash Table (Using Array)
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count[x - 'a']++;
        }

        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count[x - 'a']--;
        }

        // Check if any character has non-zero frequency
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}
