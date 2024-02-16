import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/description/
 * @author Akash Prajapati
 */
class Solution {
//    self solution
    /*public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            int sNum = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == sNum) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[2];  // no solution
    }*/

//    optimised solution
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(numsMap.containsKey(complement))
                return new int[]{numsMap.get(complement), i};

            numsMap.put(nums[i], i);
        }
        return new int[2];	// no solution
    }
}

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3,3,2,4};
        int target = 6;

        Solution obj = new Solution();
        System.out.println(Arrays.toString(obj.twoSum(nums, target)));
    }
}
