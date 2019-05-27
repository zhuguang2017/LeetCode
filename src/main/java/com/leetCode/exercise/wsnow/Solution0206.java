package com.leetCode.exercise.wsnow;

import com.leetCode.exercise.struct.ListNode;

public class Solution0206 {

	/**
	* @author 白雪红叶约  2019.05.01
	* 【题目】206. Reverse Linked List（反转链表）
	* 【思路】遍历链表一遍，按节点反转。
	* 		采用prevNode节点作为目标链表头指针，存储新链表，
	* 		采用nextNode节点作为下一节点缓存节点，用以记录原链表当前节点的下一节点，构建新链表使用。
	* 【时间复杂度】O(n)
	* 【空间复杂度】O(k)
	* @param head  原始链表头结点
	* @return <ListNode> 目标链表头结点
	*/
	public static ListNode reverseList(ListNode head) {
	    //链表为空及只有一个元素情况，直接返回本身
	    if(null==head||head.next==null)return head;
	    ListNode prevNode = null;//目标链表头节点
	    ListNode nextNode = null;//辅助用缓存节点，用以记录链表下一个节点变化
	    while(head.next != null) {
	        /*若原链表当前节点的下一个节点非空，则：
	        * 1.将当前节点下一个节点缓存至辅助的缓存节点。
	        * 2.将头结点添加至目标链表头部。
	        * 3.将目标链表头节点指针调整至目标链表头部。
	        * 4.将原链表下一节点设置为原链表头指针
	        */
	        nextNode= head.next;
	        head.next = prevNode;
	        prevNode = head;
	        head = nextNode;
	    }
	    //最后原链表余项，添加到目标链表头部，返回其即可。
	    head.next = prevNode;
	    return head;
	}
}
