/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

     示例：

     输入：1->2->4, 1->3->4
     输出：1->1->2->3->4->4

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     解法一：递归法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l2.next,l2);
            return l2;
        }
    }

    /**
     * 解法二 迭代
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }
        ListNode l3 = new ListNode(-1);
        ListNode pre = l3;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                pre = l1;
                l1 = l1.next;
            }else {
                pre = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = l1 == null?l2:l1;
        return l3;
    }



}