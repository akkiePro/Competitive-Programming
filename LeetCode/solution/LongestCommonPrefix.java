/**
 * https://leetcode.com/problems/longest-common-prefix/
 * @author Akash Prajapati
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] strs = {"","flower","flight"};
//        String[] strs = {"dog","racecar","car"};
        Solution obj = new Solution();
        System.out.println(obj.longestCommonPrefix(strs));
    }
}
/*
* case1: ["flower","flow","flight"]
* case2: ["dog","racecar","car"]
* case3: ["flower"]
* case4: ["flower", "fl", ""]
* */

/**
 * self solution
 */
class Solution {
    private StringBuilder sb;
    int minLength;
    public String longestCommonPrefix(String[] strs) {
        StringBuilder firstElement = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            sb = new StringBuilder();
            minLength = Math.min(firstElement.length(), strs[i].length());
            for (int j = 0; j < minLength; j++) {
                if (strs[i].startsWith(firstElement.substring(0, j+1)))
                    sb.append(firstElement, j, j+1);
                else
                    break;
            }
            if (!sb.isEmpty())
                firstElement = sb;
            else
                break;
        }
        return sb == null ? strs[0] : sb.toString();
    }
}

/**
 * optimised solution
 */
/*
class Solution {
    public String longestCommonPrefix(String[] strs) {

        // horizontal scan
        if (strs.length == 0){
            return "";
        }
        String prefix = strs[0];


        for (int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() -1);
                if (prefix.isEmpty()){
                    return "";
                }
            }

        }

        return prefix;
    }
}*/
