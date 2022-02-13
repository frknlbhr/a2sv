package com.ilbahar.a2sv.leetcode.linkedlist._2;

import com.ilbahar.a2sv.leetcode.linkedlist.ListNode;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode currentNode = new ListNode();
        boolean incrementOne = false;

        while (l1 != null || l2 != null || incrementOne) {
            ListNode currentNodeResult = new ListNode();
            int digit1 = l1 != null ? l1.val : 0;
            int digit2 = l2 != null ? l2.val : 0;
            int value = incrementOne ? digit1 + digit2 + 1 : digit1 + digit2;
            if (value >= 10) {
                value = value % 10;
                currentNodeResult.val = value;
                incrementOne = true;
            }
            else {
                currentNodeResult.val = value;
                incrementOne = false;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            if (result == null) {
                result = new ListNode(value, null);
                currentNode = result;
            }
            else {
                currentNode.next = currentNodeResult;
                currentNode = currentNode.next;
            }
        }
        return result;
    }

}
