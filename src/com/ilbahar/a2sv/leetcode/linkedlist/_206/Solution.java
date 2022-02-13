package com.ilbahar.a2sv.leetcode.linkedlist._206;

import com.ilbahar.a2sv.leetcode.linkedlist.ListNode;

public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextElement = current.next;
            current.next = previous;
            previous = current;
            current = nextElement;
        }
        return previous;
    }

}
