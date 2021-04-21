package 无重复字符的最长字串;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:双指针， 滑动，map,"abba"字符串问题，"abcdefg"问题
 * @Date: 2021-04-21 20:29
 * @param:
 * @return:
 **/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int result = 0;
        Map<Character, Integer> content = new HashMap<>();
        for (; j < s.length(); j++) {
            if (content.containsKey(s.charAt(j))) {
                i = Math.max(i,content.get(s.charAt(j)) + 1);
            }
            content.put(s.charAt(j), j);
            result =Math.max(j - i + 1,result);
        }
        return result;
    }
}

