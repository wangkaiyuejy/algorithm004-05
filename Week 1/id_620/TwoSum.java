/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/two-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    /**
     * 解法1 借助额外空间map 来实现，空间复杂度O（2n）（待验证TODO ） 时间复杂度O（n）
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0 ; i< nums.length;i++){
            int t = target - nums[i] ;
            if (map.containsKey(t)){
                result[0] = i;
                result[1] = map.get(t);
                return result;
            }else {
                map.put(nums[i],i);
            }
        }
        return result;

    }

    /**
     * 解法2 TODO
     */
}
