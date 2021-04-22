package 整数反转;

/**
 * @Description: 0; 余数; 除数; 自变量;越界问题处理
 * @Date: 2021-04-22 18:02
 * @param:
 * @return:
 **/
public class Solution {
    public static int reverse(int x) {
        int z;
        int result = 0;
        int temp;
        while(x != 0){
            z = x % 10;
            x = x /10;
            temp = result;
            result = result *10 + z;
            if((result -z) / 10 != temp){
                return 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(143523523));
    }
}
