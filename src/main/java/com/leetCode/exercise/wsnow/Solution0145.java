package com.leetCode.exercise.wsnow;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.leetCode.exercise.struct.TreeNode;

public class Solution0145 {
	
	/**
	 * @author 白雪红叶约 2019.05.29 
	 * 【题目】145. 二叉树的后序遍历----左右根顺序遍历
	 * 【思路】[非递归解法2]--栈顶元素不放回判断，只有当前节点为叶子节点和当前为根节点时进行出栈
	 * 栈中数据保持右子树位于左子树之下，入栈顺序根右左，故出栈顺序左右根
	 * 【时间复杂度】O(n)--每个节点都会遍历到，叶子节点访问一次，其他节点均为两次，故而为 n-2n之间，故时间复杂度为n
	 * 【空间复杂度】O(n)--额外空间为栈，栈深最大为整个树，故n。（list存储空间算的话为n）
	 * @param root
	 */
	public List<Integer> postorderTraversal3(TreeNode root) {
	    List<Integer> list = new LinkedList<Integer>();
	    if(root == null)return list;
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode pre = null;
	    stack.push(root);
	    while(!stack.isEmpty()){
	        TreeNode curr = stack.peek();            
	        if((curr.left == null && curr.right == null) ||
	           (pre != null && (pre == curr.left || pre == curr.right))){ 
	            //如果当前结点左右子节点为空或上一个访问的结点为当前结点的子节点时，当前结点出栈
	        	list.add(curr.val);
	            pre = curr;
	            stack.pop();
	        }else{
	            if(curr.right != null) stack.push(curr.right); //先将右结点压栈
	            if(curr.left != null) stack.push(curr.left);   //再将左结点入栈
	        }            
	    }
	    return list;        
	}
	
	/**
	 * @author 白雪红叶约 2019.05.29 
	 * 【题目】145. 二叉树的后序遍历----左右根顺序遍历
	 * 【思路】[非递归解法1]--栈实现根右左遍历,后翻转链表
	 * 每次先打印当前栈顶节点，随后入左-右子树，保持下一次进入是栈顶节点为原节点的右子树栈顶节点，逐级向下，最后翻转链表
	 * 【时间复杂度】O(n)--每个节点都会遍历到，故时间复杂度为n，翻转链表为n，故总和为2n
	 * 【空间复杂度】O(n)--额外空间为栈和链表，栈深最大为树的高度，故logn，链表长度为n。
	 * @param root
	 */
	public List<Integer> preorderTraversal2(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		if (null == root)
			return list;// 如果根节点为空，直接返回，避免下面出现空指针异常
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);// 将根节点推入栈中
		while (!stack.isEmpty()) {
			// 栈不为空则不断循环，直至为空，每次循环记录一个节点信息。
			// 栈顶节点始终保持为上一个记录节点信息的左-右-祖右这样的顺序
			TreeNode curNode = stack.pop();
			if (curNode.left != null) {
				// 左子树不为空，则左子树节点后入栈，保持在所有右子树节点之下位置
				stack.push(curNode.left);
			}
			if (curNode.right != null) {
				// 右子树不为空，则右子树节点先入栈，保持在所有左子树节点之上位置
				stack.push(curNode.right);
			}
			list.add(curNode.val);
		}
		LinkedList<Integer> reslist = new LinkedList<Integer>();
		for (Integer i : list) {
			reslist.add(0, i);
		}
		return reslist;
	}

	/**
	 * @author 白雪红叶约 2019.05.29 【题目】145. 二叉树的后序遍历----左右根顺序遍历
	 * 【思路】[递归解法]--先根后左右，递归进行即可 
	 * 【时间复杂度】O(n)--每个节点都会遍历到，故时间复杂度为n
	 * 【空间复杂度】O(logn)--额外空间为方法栈，栈深最大为树的高度，故logn。（list存储空间算的话为n）
	 * @param s
	 */
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		preorderTraversal1(root, list);
		return list;
	}

	public void preorderTraversal1(TreeNode node, List<Integer> list) {
		if (null == node)
			return;// 递归终止条件
		preorderTraversal1(node.left, list);// 先遍历左子树
		preorderTraversal1(node.right, list);// 接着遍历右子树
		list.add(node.val);// 最后遍历根节点值
		return;
	}

	public static void main(String[] args) {
		// 后：34521
		// 前：13245
		// 中：31425
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		List<Integer> list = new Solution0145().preorderTraversal2(root);
		for (Integer integer : list) {
			System.out.println(integer);
		}

	}
}
