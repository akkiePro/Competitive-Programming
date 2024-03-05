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
    final Map<Character, Integer> romanNumerals = new HashMap<>();
    public Solution() {
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);
    }
    // MCMXCIV
    public int romanToInt(String s) {
        if (s.isEmpty())
            throw new RuntimeException("Empty/No Roman Numeral found...");
        else if (s.length() == 1)
            return romanNumerals.get(s.charAt(0));
        else {
            char current = s.charAt(s.length()-1);
            char next = s.charAt(s.length()-2);
            if (romanNumerals.get(current) > romanNumerals.get(next))
                if (s.length() > 2)
                    return romanNumerals.get(current) - romanNumerals.get(next) + romanToInt(s.substring(0, s.length()-2));
                else
                    return romanNumerals.get(current) - romanNumerals.get(next);
            else
                return romanNumerals.get(current) + romanToInt(s.substring(0, s.length()-1));
        }
    }
}
