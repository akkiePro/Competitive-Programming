import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * @author Akash Prajapati
 */
public class RomanToInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s");
        String s = sc.nextLine().toUpperCase();

        System.out.println("Your Roman numeral: " + s);

        Solution obj = new Solution();
        System.out.println(obj.romanToInt(s));
    }
}

/**
 * self solution
 */
class Solution {
    final char[] romanLiterals = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    final Map<Character, Integer> romans = new HashMap<>();
    public Solution() {
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
    }
    // MCMXCIV
    public int romanToInt(String s) {
        if (s.isEmpty())
            throw new RuntimeException("Empty/No Roman Numeral found...");
        else if (s.length() == 1)
            return romans.get(s.charAt(0));
        else {
            char current = s.charAt(s.length()-1);
            char next = s.charAt(s.length()-2);
            if (romans.get(current) > romans.get(next))
                if (s.length() > 2)
                    return romans.get(current) - romans.get(next) + romanToInt(s.substring(0, s.length()-2));
                else
                    return romans.get(current) - romans.get(next);
            else
                return romans.get(current) + romanToInt(s.substring(0, s.length()-1));
        }
    }
}
