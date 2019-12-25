package leetcode;

import java.util.Arrays;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : TrappingRainWater
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 42. Trapping Rain Water
 */
public class TrappingRainWater {
    /**
     *

     0,1,0,2,1,0,1,3,2,1,2,1

                   *
           *       * *   *
       *   * *   * * * * * *
     0 1 2 3 4 5 6 7 8 9 0 1
                 l r

     time : O(n)
     space : O(1)

     *
     * @param height
     * @return
     */
    //例:[0,1,0,2,1,0,1,3,2,1,2,1]
    //题解:https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {//至少要两个柱子才可能接水,虽然只有两个柱子的接水为0，但是计算的时候会计算到
            if (height[left] <= height[right]) {//由短边决定接水量
                leftMax = Math.max(height[left], leftMax);
                res += leftMax - height[left];//height[left]小于leftMax时,res接水量增加,否则不增加
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
