package com.leetCode.exercise.wsnow;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.leetCode.exercise.struct.TreeNode;

public class Solution0144 {
	
	
	
	/**
	* @author 白雪红叶约  2019.05.29
	* 【题目】144. 二叉树的前序遍历----根左右顺序遍历
	* 【思路】[非递归解法]--建立栈，利用栈的后进先出原则，倒放即可。
	* 每次先打印当前栈顶节点，随后入右-左子树，保持下一次进入是栈顶节点为原节点的左子树栈顶节点，逐级向下
	* 【时间复杂度】O(n)--每个节点都会遍历到，故时间复杂度为n
	* 【空间复杂度】O(logn)--额外空间为栈，栈深最大为树的高度，故logn。（list存储空间算的话为n）
	* @param root 
	 */
	public List<Integer> preorderTraversal2(TreeNode root) {
		 List<Integer> list=new LinkedList<Integer>();
		 if(null==root)return list;//如果根节点为空，直接返回，避免下面出现空指针异常
		 Stack<TreeNode> stack=new Stack<TreeNode>();
		 stack.push(root);//将根节点推入栈中
		 while(!stack.isEmpty()){
			 //栈不为空则不断循环，直至为空，每次循环记录一个节点信息。
			 //栈顶节点始终保持为上一个记录节点信息的左-右-祖右这样的顺序
			 TreeNode curNode=stack.pop();
			 list.add(curNode.val);
			 if(curNode.right!=null){
				 //右子树不为空，则右子树节点先入栈，保持在所有左子树节点之下位置
				 stack.push(curNode.right);
			 }
			 if(curNode.left!=null){
				 //左子树不为空，则左子树节点后入栈，保持在所有右子树节点之上位置
				 stack.push(curNode.left);
			 }
		 }
		 return list;
	 }
	
	
	/**
	* @author 白雪红叶约  2019.05.29
	* 【题目】144. 二叉树的前序遍历----根左右顺序遍历
	* 【思路】[递归解法]--先根后左右，递归进行即可
	* 【时间复杂度】O(n)--每个节点都会遍历到，故时间复杂度为n
	* 【空间复杂度】O(logn)--额外空间为方法栈，栈深最大为树的高度，故logn。（list存储空间算的话为n）
	* @param s  
	 */
	 public List<Integer> preorderTraversal1(TreeNode root) {
		 List<Integer> list=new LinkedList<Integer>();
		 preorderTraversal1(root,list);
		 return list;
	 }
	 public void preorderTraversal1(TreeNode node,List<Integer> list){
		 if(null==node)return;//递归终止条件
		 list.add(node.val);//先遍历根节点值
		 preorderTraversal1(node.left,list);//接着遍历左子树
		 preorderTraversal1(node.right,list);//接着遍历右子树
		 return;
	 }
	 
	 public static void main(String[] args) {
		 TreeNode root = new TreeNode(1);
		 root.right=new TreeNode(2);
		 root.left=new TreeNode(3);
		 root.right.left=new TreeNode(4);
		 root.right.right=new TreeNode(5);
		 List<Integer> list= new Solution0144().preorderTraversal1(root); 
		 for (Integer integer : list) {
			System.out.println(integer);
		}

	}
}
