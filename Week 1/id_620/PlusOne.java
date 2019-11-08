/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:

 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。
 示例 2:

 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/plus-one
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    /**
     * 解法1使用递归
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0 || (digits.length == 1 && digits[0] == 0)){
            return digits;
        }

        int level = digits.length-1;
        plusOne(level,digits);
        if (digits[0] == 0){
            int[]  result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(result,1,digits,0,digits.length);
            return result;
        }else {
            return digits;
        }
    }

  public void   plusOne(int level ,int[] digits){
      //退出条件
      if (level < 0){
          return;
      }
      //当前逻辑
      int t = digits[level]+1;
      if (t>9){
          //递归
          digits[level] = 0;
          level--;
          plusOne(level,digits);
      }else {
          digits[level] = t;
          return;
      }
      //清理状态
  }
}

/**
 * 在leetcode 上看到的非常棒的解法 收藏
 */
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}

