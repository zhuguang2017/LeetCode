package com.leetCode.exercise.wsnow;

import com.leetCode.exercise.struct.TreeNode;

public class Solution0236 {

	/**
	 * @author 白雪红叶约 2019.05.30 
	 * 【题目】236. 二叉树的最近公共祖先
	 * 【思路】分治，从根节点开始逐层搜索，判断pq所处位置
	 * 		1.pq任意一个与此节点相同，说明结果为此节点。
	 * 		2.遍历左右子树，得到左右子树的。
	 * 		3.pq均大于根节点，说明位于右子树，则向右遍历。
	 * 		4.pq位于根节点两侧，说明最近公共祖先就是根节点
	 * 【时间复杂度】O(logn)--逐层搜索，所以为层高1-logn
	 * 【空间复杂度】O(1)--无额外空间，故空间复杂度为0，即O（1）
	 * @param root
	 */
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	      if(root==null||root==p||root==q)return root ;
	      TreeNode left=lowestCommonAncestor(root.left,p,q);
	      TreeNode right=lowestCommonAncestor(root.right,p,q);
	      return left==null?right:right==null?left:root;
	 }
}
