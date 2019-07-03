package com.leetCode.exercise.wsnow;

import java.util.Stack;

import com.leetCode.exercise.struct.ListNode;

public class Solution0160 {
	 public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		 Stack<ListNode> stackA=new Stack<ListNode>();
		 Stack<ListNode> stackB=new Stack<ListNode>();
		 ListNode ta = headA , tb = headB , tmp = null;
		 while(null!=ta){
			 stackA.push(ta);
			 ta=ta.next;
		 }
		 while(null!=tb){
			 stackB.push(tb);
			 tb=tb.next;
		 }
		 int len= Math.max(stackA.size(), stackB.size());
		 for (int i = 0; i < len; i++) {
			if(stackA.isEmpty()||stackB.isEmpty())return tmp;
			if(stackA.peek()!=stackB.peek())return tmp;
			tmp=stackA.pop();
			stackB.pop();
		}
		return tmp;
	 }
	 
	 
	 public static void main(String[] args) {
		 ListNode a=new ListNode();
		 a.val=1;
		 a.next=new ListNode();
		 a.next.val=2;
		 ListNode b=new ListNode();
		 b.val=3;
		 b.next=new ListNode();
		 b.next.val=2;
		 a.next.next=new ListNode();
		 b.next.next=a.next.next;
		 a.next.next.val=4;
		 a.next.next.next=new ListNode();
		 a.next.next.next.val=5;
		 System.out.println(getIntersectionNode(a,b).val);
				 
	}
}
