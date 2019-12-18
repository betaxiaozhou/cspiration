package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MissingNumber
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 268. Missing Number
 */
public class MissingNumber {
    /**
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

     For example,
     Given nums = [0, 1, 3] return 2.

     time : O(n)
     space : O(1)

     * @param nums
     * @return
     */
    //位运算是最好的方法
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }
    //等差数列的方法
    public int missingNumber(int[] nums) {
        //n = nums.length,下面nums.length + 1的 原因是/2可能少算
        int expectedSum = nums.length * (nums.length + 1) / 2;//Sn=[n*(a1+an)]/2
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

}
