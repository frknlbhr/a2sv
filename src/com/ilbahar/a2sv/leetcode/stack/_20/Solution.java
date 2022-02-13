package com.ilbahar.a2sv.leetcode.stack._20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        Map<Character, Character> paranthesesMatchingMap = new HashMap<>();
        paranthesesMatchingMap.put('(', ')');
        paranthesesMatchingMap.put('[', ']');
        paranthesesMatchingMap.put('{', '}');
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                characterStack.push(aChar);
            } else {
                if (characterStack.isEmpty()) {
                    return false;
                }
                Character charInStack = characterStack.pop();
                if (charInStack == null || !paranthesesMatchingMap.get(charInStack).equals(aChar)) {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }

}
