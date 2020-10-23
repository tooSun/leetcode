package com.hlb.removeNthNodeFromEndOfList;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import com.hlb.dataStructure.ListNode;

/**
 * 删除链表的倒数第N个节点
 *
 * @author hlb
 * @date 2020/10/19 10:17
 *
 */
public class Sulation {

	// 1->2->3->4->5
	public static void main(String[] args) {
		ListNode l5 = new ListNode(5, null);
		ListNode l4 = new ListNode(4, l5);
		ListNode l3 = new ListNode(3, l4);
		ListNode l2 = new ListNode(2, l3);
		ListNode l1 = new ListNode(1, l2);

		ListNode cur = l1;
		while(null != cur) {
			System.out.print(cur.val + "->");
			cur = cur.next;
		}

		System.out.println();

		l1 = f3(l1, 6);

		cur = l1;
		while(null != cur) {
			System.out.print(cur.val + "->");
			cur = cur.next;
		}

	}

	/**
	 * 自解-计算链表长度
	 *
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode f1(ListNode head, int n) {
		if(n < 0) {
			return null;
		}

		ListNode cur = head;
		int total = 0;
		while(cur != null) {
			cur = cur.next;
			total++;
		}

		cur = head;
		while(cur != null) {
			if(n == (total - 1)) {
				if(null != cur.next) {
					cur.next = cur.next.next;
				}
				return head;
			} else if(n == total) {
				head = cur.next;
				return head;
			}
			cur = cur.next;
			total--;
		}

		return head;
	}

	/**
	 * 栈
	 *
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode f2(ListNode head, int n) {
		if(n < 0) {
			return null;
		}

		ListNode cur = head;
		Deque<ListNode> stack = new LinkedList<>();
		while(null != cur) {
			stack.push(cur);
			cur = cur.next;
		}

		for(int i = 0; i < n; i++) {
			stack.pop();
		}

		ListNode pre = stack.peek();
		if(null != pre && null != pre.next) {
			pre.next = pre.next.next;
		} else if(null == pre) {
			head = head.next;
		}

		return head;
	}

	/**
	 * 一次遍历
	 *
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode f3(ListNode head, int n) {
		if(n < 0) {
			return null;
		}

		ListNode dummy = new ListNode(0, head);
		ListNode first = head;
		ListNode second = dummy;
		for(int i = 0; i < n; i++) {
			first = first.next;
		}

		while (null != first) {
			first = first.next;
			second = second.next;
		}

		if(null != second.next) {
			second.next = second.next.next;
		}

		return dummy.next;
	}

}
