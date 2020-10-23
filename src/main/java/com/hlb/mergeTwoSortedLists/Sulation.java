package com.hlb.mergeTwoSortedLists;

import com.hlb.dataStructure.ListNode;

/**
 * 合并两个有序链表
 *
 * @author hlb
 * @date 2020/10/22 9:37
 *
 */
public class Sulation {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

//		ListNode result = f1(l1, l2);
		ListNode result = f2(l1, l2);

		while (result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
		System.out.println();

	}

	/**
	 * 迭代
	 *
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode f1(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(0);
		ListNode pos = dummy;
		while(l1 != null || l2 != null) {
			if(l1 == null) {
				pos.next = l2;
				break;
			} else if(l2 == null) {
				pos.next = l1;
				break;
			} else if(l1.val < l2.val) {
				pos.next = l1;
				l1 = l1.next;
				pos = pos.next;
			} else {
				pos.next = l2;
				l2 = l2.next;
				pos = pos.next;
			}

		}

		return dummy.next;
	}

	/**
	 * 递归
	 *
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode f2(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		} else if(l2 == null) {
			return l1;
		} else if(l1.val < l2.val) {
			l1.next = f2(l1.next, l2);
			return l1;
		} else {
			l2.next = f2(l1, l2.next);
			return l2;
		}
	}

}
