import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate/description/
 * @author Akash Prajapati
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 1, 4};
        int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};
//        int[] nums = new int[]{1,2,3,4};
        Solution obj = new Solution();
        System.out.println(obj.containsDuplicate(nums));
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> container = new HashSet<>();
        for (int num : nums) {
            if (container.contains(num)) {
                return true;
            }
            container.add(num);
        }
        return false;
    }
}