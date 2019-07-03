package com.leetCode.exercise.wsnow;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.leetCode.exercise.struct.TreeNode;

public class Solution0098 {
	 /**
	  * @author 白雪红叶约 2019.05.30 
	  * 【题目】98. 验证二叉搜索树
	  * 【思路】 先中序遍历，如果是二叉搜索树，则结果为增项，for循环判断即可
	  * 【时间复杂度】O(n)--中序n，遍历n，结果为2n 
	  * 【空间复杂度】O(n)--栈为logn，链表为n，故为n
	  * @param root	根节点
	  * @return <boolean> true-为二叉搜索树 false-不为二叉搜索树
	  */
	  public boolean isValidBST1(TreeNode root) {
		  List<Integer> list=new LinkedList<Integer>();
		 Stack<TreeNode> stack=new Stack<TreeNode>();
		 TreeNode node=root;
		 if(null==node)return true;//如果根节点为空，直接返回，避免下面出现空指针异常
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
		 Long t=Long.MIN_VALUE;
		 for (Integer c : list) {
			if(Long.valueOf(c)>t){
				t=Long.valueOf(c);
				continue;
			}else{
				return false;
			}
		 }
		 return true;
	  }
	
	
	 /**
	  * @author 白雪红叶约 2019.05.30 
	  * 【题目】98. 验证二叉搜索树
	  * 【思路】 递归判断，每层判断当前节点是否符合范围，后判断左子树右子树情况
	  * 【时间复杂度】O(n)--每个节点便利一遍，所以为n
	  * 【空间复杂度】O(1)--额外空间为0，运行时方法栈不参与算法空间复杂度计算
	  * @param root	根节点
	  * @return <boolean> true-为二叉搜索树 false-不为二叉搜索树
	  */
	  public boolean isValidBST(TreeNode root) {
		  return isValid(root,Long.MAX_VALUE,Long.MIN_VALUE);
	  }
	  
	  public boolean isValid(TreeNode root,Long max,Long min){
		  if(root==null)return true;
		  if(root.val>=max||root.val<=min)return false;
		  return isValid(root.left,Long.valueOf(root.val),min)&&isValid(root.right,max,Long.valueOf(root.val));
	  }
}
