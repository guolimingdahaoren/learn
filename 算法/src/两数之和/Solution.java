package 两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 关键词 ：Map
 * @Date: 2021-04-11 19:11
 **/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i< nums.length;i++){
            if(map.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return result;
    }
}
