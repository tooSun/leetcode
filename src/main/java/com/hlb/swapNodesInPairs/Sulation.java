package com.hlb.swapNodesInPairs;

import com.hlb.dataStructure.ListNode;

/**
 * 两两交换链表中的节点
 *
 * @author hlb
 * @date 2020/10/23 14:45
 *
 */
public class Sulation {

	public static void main(String[] args) {

		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//		ListNode head = null;

		ListNode pos = head;
		while (pos != null) {
			System.out.print(pos.val + "->");
			pos = pos.next;
		}
		System.out.println();

		ListNode node = f3(head);

		pos = node;
		while (pos != null) {
			System.out.print(pos.val + "->");
			pos = pos.next;
		}
		System.out.println();
	}

	/**
	 * 自解-迭代
	 *
	 * @param head
	 * @return
	 */
	public static ListNode f1(ListNode head) {

		if(head.next == null) {
			return null;
		}
		ListNode head0 = new ListNode(0, head);
		ListNode pre = head0;
		ListNode pos = pre.next;
		int i = 1;
		while (pos != null) {
			if(i % 2 != 0) {
				ListNode tmp = pos.next;
				if(pos.next == null) {
					return head0.next;
				}
				pos.next = pos.next.next;
				tmp.next = pos;
				pre.next = tmp;
			}
			i ++;
			pre = pre.next;
			pos = pre.next;
		}

		return head0.next;
	}

	/**
	 * 递归
	 *
	 * @param head
	 * @return
	 */
	public static ListNode f2(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode newHead = head.next;
		head.next = f2(newHead.next);
		newHead.next = head;
		return newHead;
	}

	/**
	 * 迭代
	 *
	 * @param head
	 * @return
	 */
	public static ListNode f3(ListNode head) {
		ListNode dummyHead = new ListNode(0, head);
		ListNode tmp = dummyHead;
		while (tmp.next != null && tmp.next.next != null) {
			ListNode node1 = tmp.next;
			ListNode node2 = tmp.next.next;
			node1.next = node2.next;
			node2.next = node1;
			tmp.next = node2;
			tmp = node1;
		}

		return dummyHead.next;
	}

}
