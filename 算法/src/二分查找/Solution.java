package 二分查找;

public class Solution {

    public static  boolean binarySearch(int[] arr,int number){
        int left = 0;
        int right = arr.length - 1;
        int middle = -1;

        while(middle != left &&  middle != right){
             middle = (left + right) / 2;
            if(arr[middle] == number){
                return true;
            }
            if(number < arr[middle]){
                right = middle;
            }
            if(number > arr[middle]){
                left = middle;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{0,1,2,3,4,5},4));
    }
}
