package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FindMinimuminRotatedSortedArrayII
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class FindMinimuminRotatedSortedArrayII {
    /**
     * 154. Find Minimum in Rotated Sorted Array II
     *
     *
     * 6 7 8 9 1 3 5;
     * 1 1 1 1 2 1
     *
     * time : O(logn)  worst: O(n);
     * space : O(1);
     * @param nums
     * @return
     */
     public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < nums[end]) {//不能有=
                end = mid;
            } else if (nums[mid] > nums[end]) {//也不能有=
                start = mid + 1;
            } else {//避免这种情况[1,3,3],3，没有这个else ，结果返回3
                end--;//[1,1,3,1],nums[mid]==nums[end];
            }
        }
        if (nums[start] < nums[end]) return nums[start];
        else return nums[end];
    }
    
    
    public int findMin2(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {//例子:[4,5,6,0,1,2,3]
            int mid = (end - start) / 2 + start;
            if (nums[mid] > nums[end]) start = mid + 1;
            else if (nums[mid] < nums[end]) end = mid;
            else end = end - 1;//例子:[1,1,0,1]
        }
        return nums[start];
    }
}
