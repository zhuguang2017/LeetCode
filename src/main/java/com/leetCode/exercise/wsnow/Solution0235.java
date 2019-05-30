package com.leetCode.exercise.wsnow;

import com.leetCode.exercise.struct.TreeNode;

public class Solution0235 {
	
	
	/**
	 * @author 白雪红叶约 2019.05.30 
	 * 【题目】235. 二叉搜索树的最近公共祖先
	 * 【思路】从根节点开始逐层搜索，判断pq所处位置
	 * 		1.pq任意一个与根节点相同，说明结果为根节点。
	 * 		2.pq均小于根节点，说明位于左子树，则向左遍历。
	 * 		3.pq均大于根节点，说明位于右子树，则向右遍历。
	 * 		4.pq位于根节点两侧，说明最近公共祖先就是根节点
	 * 【时间复杂度】O(logn)--逐层搜索，所以为层高1-logn
	 * 【空间复杂度】O(1)--无额外空间，故空间复杂度为0，即O（1）
	 * @param root
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val==root.val||q.val==root.val){
			return root;
		}else if(p.val<root.val&&q.val<root.val){
			return lowestCommonAncestor(root.left,p,q);
		}else if(p.val>root.val&&q.val>root.val){
			return lowestCommonAncestor(root.right,p,q);
		}else{
			return root;
		}
    }
}
