package com.leetCode.exercise.wsnow;

import java.util.HashSet;
import java.util.Set;

import com.leetCode.exercise.struct.ListNode;

public class Solution0141 {
	/**
	 * @author 白雪红叶约 2019.05.01 
	 * 【题目】141. linked-list-cycle（链表是否有环） 
	 * 【思路】快慢指针。
	 *         利用快指针与慢指针同步遍历链表，当有环情况下两者会相遇的特性解题 
	 * 【时间复杂度】O(n+k) 
	 * 【空间复杂度】O(1)
	 * @param head	原始链表头结点
	 * @return <boolean> true-存在环 false-不存在环
	 */
	public static boolean hasCycle1(ListNode head) {
		if (null == head || head.next == null)
			return false;
		ListNode fastNode = head.next.next;// 快指针
		ListNode slowNode = head.next;// 慢指针
		while (fastNode != slowNode) {
			if (fastNode == null || null == fastNode.next)
				return false;
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}
		return true;
	}
	
	/**
	 * @author 白雪红叶约 2019.05.01 
	 * 【题目】141. linked-list-cycle（链表是否有环） 
	 * 【思路】缓存记录法。
	 *      遍历一遍链表，每项均添加入缓存set中，判断是否遍历过此节点确定是否有环
	 * 【时间复杂度】O(n) 
	 * 【空间复杂度】O(n)
	 * @param head 原始链表头结点
	 * @return <boolean> true-存在环 false-不存在环
	 */
	public static boolean hasCycle2(ListNode head) {
		Set<ListNode> cacheSet = new HashSet<ListNode>();
		while (!cacheSet.contains(head)) {
			if (head == null)
				return false;
			cacheSet.add(head);
			head = head.next;
		}
		return true;
	}
}
