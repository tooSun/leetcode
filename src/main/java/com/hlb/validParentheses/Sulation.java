package com.hlb.validParentheses;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 * 有效的括号
 *
 * @author hlb
 * @date 2020/9/7 17:08
 *
 */
public class Sulation {

	public static void main(String[] args) {

		System.out.println(f1("()"));

	}

	public static boolean f1(String s) {

		if(null == s || s.trim().length() < 1 || s.length() % 2 == 1) {
			return false;
		}

		Map<Character, Character> m = new HashMap<>();
		m.put(')', '(');
		m.put(']', '[');
		m.put('}', '{');

		Deque<Character> q = new LinkedList<>();
		for(int i = 0; i < s.length(); i++) {
			if(!m.containsKey(s.charAt(i))) {
				q.push(s.charAt(i));
			} else {
				if(!q.isEmpty() && q.peek().equals(m.get(s.charAt(i)))) {
					q.pop();
				} else {
					return false;
				}
			}
		}

		if(q.isEmpty()) {
			return true;
		}

		return false;
	}

}
