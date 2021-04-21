package 最长回文子串;

/**
 * @Description:中间字符对折相等，中心扩散，注意-> 扩散下标不是最终的字符下标
 * @Date: 2021-04-21 16:57
 * @param:
 * @return:
 **/
public class Solution {
    public static  String longestPalindrome(String s) {
        int index1 = 0;
        int index2 = 0;
      for(int i =0;i < s.length();i++){
          int temp1 = i - 1;
          int temp2 = i + 1;
          while(temp1 >= 0 && s.charAt(temp1) == s.charAt(i)){
              temp1--;
          }
          while(temp2 < s.length() && s.charAt(temp2) == s.charAt(i)){
              temp2++;
          }
          while(temp1 >=0 && temp2<s.length() && s.charAt(temp1) == s.charAt(temp2)){
              temp1--;
              temp2++;
          }
          temp1 = temp1 + 1;
          temp2 = temp2 - 1;
          if((temp2 - temp1) > (index2 - index1)){
                index1 = temp1;
                index2 = temp2;
          }
      }
      return s.substring(index1,index2 + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
