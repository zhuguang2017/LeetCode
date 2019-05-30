package com.leetCode.exercise.wsnow;

import com.leetCode.exercise.struct.TreeNode;

public class Solution0226 {
	
	/**
	 * @author 白雪红叶约 2019.05.30 
	 * 【题目】226. 翻转二叉树
	 * 【思路】逢空返回，递归解题
	 * 【时间复杂度】O(n)--每个节点都会遍历到，故时间复杂度为3n
	 * 【空间复杂度】O(1)--额外空间为转换节点，空间复杂度为1
	 * @param root
	 */
	 public TreeNode invertTree(TreeNode root) {
         if(root==null)return null;
         TreeNode tmp=root.left;
         root.left=invertTree(root.right);
         root.right=invertTree(tmp);
         return root;
   }
}
