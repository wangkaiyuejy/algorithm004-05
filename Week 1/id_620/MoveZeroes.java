/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:

 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 说明:

 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。
 在真实的面试中遇到过这道题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/move-zeroes
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public void moveZeroes(int[] nums) {
        //记录当前的位置
        //记录0的个数
        for (int i=0;i<nums.length;i++){
            int t = i;
            while (nums[t] == 0 && i<nums.length){
                i++;
                if (i<nums.length && nums[i] != 0){
                    nums[t] = nums[i];
                    nums[i] = 0;
                    i=t;
                }
            }
        }
    }

    /**
     * 使用 使用双指针法
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        int j = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        for (int r = j; r < nums.length; r++){
            nums[r] = 0;
        }
    }

}