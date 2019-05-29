package com.leetCode.exercise.wsnow;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.leetCode.exercise.struct.TreeNode;

public class Solution0094 {
	/**
	* @author 白雪红叶约  2019.05.29
	* 【题目】94. 二叉树的中序遍历----左根右顺序遍历
	* 【思路】[非递归解法]--一路向左，知道找到左子树的叶子节点或者是没有左子树的最后一个节点，沿途节点入栈。
	* 每次先打印当前栈顶节点，随后入右-左子树，保持下一次进入是栈顶节点为原节点的左子树栈顶节点，逐级向下
	* 【时间复杂度】O(n)--每个节点都会遍历到，故时间复杂度为n
	* 【空间复杂度】O(logn)--额外空间为栈，栈深最大为树的高度，故logn。（list存储空间算的话为n）
	* @param root 
	 */
	public List<Integer> preorderTraversal2(TreeNode root) {
		 List<Integer> list=new LinkedList<Integer>();
		 Stack<TreeNode> stack=new Stack<TreeNode>();
		 TreeNode node=root;
		 if(null==node)return list;//如果根节点为空，直接返回，避免下面出现空指针异常
		 while(node!=null||!stack.isEmpty()){
			 while(node!=null){
				 //一路向左，知道找到左子树的叶子节点或者是没有左子树的最后一个节点，沿途节点入栈
				 stack.push(node);
				 node=node.left;
			 }
			 if(!stack.isEmpty()){
				 //如果栈非空，说明存在需要处理的节点元素--栈顶为处理节点
				 node=stack.pop();
				 //由于上面while循环保障，此节点无左子树，故而作为根节点添加
				 list.add(node.val);
				 //下一轮处理当前节点右节点，以此迭代执行
				 node=node.right;
			 }
		 }
		 return list;
	 }
	
	
	/**
	* @author 白雪红叶约  2019.05.29
	* 【题目】94. 二叉树的中序遍历----左根右顺序遍历
	* 【思路】[递归解法]--先左后根右，递归进行即可
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
		 preorderTraversal1(node.left,list);//先遍历左子树
		 list.add(node.val);//接着遍历根节点值
		 preorderTraversal1(node.right,list);//最后遍历右子树
		 return;
	 }
	 
	 public static void main(String[] args) {
		 //后：34521
		 //前：13245
		 //中：31425
		 TreeNode root = new TreeNode(1);
		 root.right=new TreeNode(2);
		 root.left=new TreeNode(3);
		 root.right.left=new TreeNode(4);
		 root.right.right=new TreeNode(5);
		 List<Integer> list= new Solution0094().preorderTraversal2(root); 
		 for (Integer integer : list) {
			System.out.println(integer);
		}

	}
}
