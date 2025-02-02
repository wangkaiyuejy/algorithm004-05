
/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

 示例 1:

 输入: [1,2,3,4,5,6,7] 和 k = 3
 输出: [5,6,7,1,2,3,4]
 解释:[7,6,5,4,3,2,1]
 向右旋转 1 步: [7,1,2,3,4,5,6]
 向右旋转 2 步: [6,7,1,2,3,4,5]
 向右旋转 3 步: [5,6,7,1,2,3,4]
 示例 2:

 输入: [-1,-100,3,99] 和 k = 2
 输出: [3,99,-1,-100]
 解释:
 向右旋转 1 步: [99,-1,-100,3]
 向右旋转 2 步: [3,99,-1,-100]
 说明:

 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 要求使用空间复杂度为 O(1) 的 原地 算法。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/rotate-array
 */
class Solution {
    /**
     * 解法1 暴力解法
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

        if (k > nums.length){
            k = k%nums.length;
        }

        for (int i = 0 ;i < k ; i++){
            int t = nums[nums.length-1];
            for (int j = nums.length-1-1;j >= 0 ; j -- ){
                nums[j+1] = nums[j];
            }
            nums[0] = t;
        }
    }


    /**
     * 解法2 反转法
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public static void reverse(int[] nums ,int start,int end){
        while (start < end ){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 解法3 循环替换法
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int count = 0;
        for (int i = 0; count<nums.length; i++ ){
            int current = i;
            int pre = nums[i];
            int next = (current+k)%nums.length;
            while(current != i){
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                current = next;
                count++;
            }
        }
    }
}