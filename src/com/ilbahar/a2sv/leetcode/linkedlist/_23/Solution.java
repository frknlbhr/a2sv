package com.ilbahar.a2sv.leetcode.linkedlist._23;

import com.ilbahar.a2sv.leetcode.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> listNodes = Arrays.asList(lists);
        List<ListNode> modifiableListNodes = new ArrayList<>(listNodes);
        List<ListNode> listNodesCopy = new ArrayList<>(modifiableListNodes);

        while (modifiableListNodes.size() > 1) {
            for (int i = 0; i < listNodesCopy.size() / 2; i++) {
                ListNode resultNode = mergeTwoLists(listNodesCopy.get(i), listNodesCopy.get(listNodesCopy.size() - 1 - i));
                modifiableListNodes.remove(listNodesCopy.get(i));
                modifiableListNodes.remove(listNodesCopy.get(listNodesCopy.size() - 1 - i));
                modifiableListNodes.add(resultNode);
            }
            listNodesCopy = new ArrayList<>(modifiableListNodes);
        }
        return !modifiableListNodes.isEmpty() ? modifiableListNodes.get(0) : null;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode currentNode = new ListNode();

        while (l1 != null || l2 != null) {
            int value1 = l1 != null ? l1.val : Integer.MAX_VALUE;
            int value2 = l2 != null ? l2.val : Integer.MAX_VALUE;
            int minValue = Math.min(value1, value2);
            ListNode currentNodeResult = new ListNode(minValue);
            if (value1 != value2) {
                if (minValue == value1)
                    l1 = l1 != null ? l1.next : null;
                if (minValue == value2)
                    l2 = l2 != null ? l2.next : null;
            }
            else {
                l1 = l1 != null ? l1.next : null;
            }

            if (result == null) {
                result = new ListNode(minValue, null);
                currentNode = result;
            }
            else {
                if (minValue != Integer.MAX_VALUE) {
                    currentNode.next = currentNodeResult;
                    currentNode = currentNode.next;
                }
            }
        }
        return result;
    }

}
