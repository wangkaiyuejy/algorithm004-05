/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

 示例 1:

 输入: "(()"
 输出: 2
 解释: 最长有效括号子串为 "()"
 示例 2:

 输入: ")()())"
 输出: 4
 解释: 最长有效括号子串为 "()()"

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    /**
     * 使用栈的方式
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {

        Stack<Integer> stringStack = new Stack<Integer>();
        int maxLen = 0;
        stringStack.push(-1);
        for (int i = 0; i<s.length(); i++){
            if (String.valueOf(s.charAt(i)).equals("(")){
                stringStack.push(i);
            }else {
                stringStack.pop();
                if (stringStack.isEmpty()){
                    stringStack.push(i);
                }else {
                    maxLen = Math.max(maxLen,i-stringStack.peek());
                }
            }

        }
        return maxLen;

    }
    /**
     * 动态规划法
     */
    public int longestValidParentheses2(String s) {

        int[] strarr = new int[s.length()];
        int maxLen = 0;
        for (int i = 0 ; i<s.length();i++){
            if (String.valueOf(s.charAt(i)).equals("(")){
                continue;
            }else {
                if (String.valueOf(s.charAt(i-1)).equals("(")){
                    strarr[i] = i>=2?strarr[i-2]:0+2;
                }else if (String.valueOf(s.charAt(i-strarr[i-1]-1)).equals(")")){
                    strarr[i] = strarr[i-1]+strarr[i-strarr[i-1]-2]+2;
                }
            }
            maxLen = Math.max(maxLen,strarr[i]);
        }
        return maxLen;

    }
    /**
     * 无需额外空间法
     */
}