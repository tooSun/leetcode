package com.hlb.addTwoNumbers;

import com.hlb.dataStructure.ListNode;

/**
 * 两数相加
 *
 * @author hlb
 * @date 2020/9/7 11:35
 *
 */
public class Sulation {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(0);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);

		ListNode l3 = f1(l1, l2);

		while (null != l3) {
			System.out.println(l3.val);
			l3 = l3.next;
		}

	}

	/**
	 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * 输出：7 -> 0 -> 8
	 * 原因：342 + 465 = 807
	 *
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode f1(ListNode l1, ListNode l2) {

		int flag = 0;
		ListNode head = new ListNode(0);
		ListNode tail = head;
		while(null != l1 || null != l2) {
			int s = 0;
			if(null != l1) {
				s += l1.val;
				l1 = l1.next;
			}
			if(null != l2) {
				s += l2.val;
				l2 = l2.next;
			}
			s += flag;
			flag = s / 10;
			tail.next = new ListNode(s % 10);
			tail = tail.next;
		}
		if(flag > 0) {
			tail.next = new ListNode(flag);
		}

		return head.next;
	}

}
