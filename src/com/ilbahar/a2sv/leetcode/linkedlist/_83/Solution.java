package com.ilbahar.a2sv.leetcode.linkedlist._83;

import com.ilbahar.a2sv.leetcode.linkedlist.ListNode;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode currentNode = head;

        while (currentNode.next != null) {
            if (currentNode.val == currentNode.next.val) {
                ListNode nextNext = currentNode.next.next;
                currentNode.next = nextNext;
            }
            else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }

}
