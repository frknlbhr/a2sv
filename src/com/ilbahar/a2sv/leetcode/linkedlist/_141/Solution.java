package com.ilbahar.a2sv.leetcode.linkedlist._141;

import com.ilbahar.a2sv.leetcode.linkedlist.ListNode;

public class Solution {

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode fast = head;
        ListNode slow = head;

        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

}
