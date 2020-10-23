package com.hlb.palindromeLinkedList;

import java.util.Deque;
import java.util.LinkedList;

import com.hlb.dataStructure.ListNode;

/**
 * 回文链表
 *
 * @author hlb
 * @date 2020/10/23 16:55
 *
 */
public class Sulation {

	public static void main(String[] args) {

		ListNode head = new ListNode(1, new ListNode(2, new ListNode(1)));

		System.out.println(f1(head));

	}

	public static boolean f1(ListNode head) {
		if(null == head) {
			return false;
		}
		int count = 0;
		ListNode pos = head;
		while (pos != null) {
			count ++;
			pos = pos.next;
		}
		if(count == 1) {
			return true;
		}
		int median = count / 2 + 1;
		count = 0;
		Deque<Integer> deque = new LinkedList<>();
		while (head != null) {
			if(count > 0 && count + 1 >= median) {
				if(deque.pop() != head.val) {
					return false;
				}
			} else {
				deque.push(head.val);
			}
			head = head.next;
			count ++;
		}

		return true;
	}

}
