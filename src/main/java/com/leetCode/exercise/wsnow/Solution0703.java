package com.leetCode.exercise.wsnow;

import java.util.PriorityQueue;

public class Solution0703 {
	
	public static void main(String[] args) {
		
	}
	
	

}
/**
 * @author 白雪红叶约  2019.05.27
* 【题目】703. 数据流中的第K大元素
* 【思路】 优先级队列实现，维持一个k个元素的小顶堆，每次比较新入元素是否大于堆顶元素，若是则移除堆顶元素
* （堆中最小的元素），加入新入元素，并返回当前最小的那个元素即为第K大元素
* 【时间复杂度】O(n|logn)--初始化构造函数遍历构建为O(n)，插入为堆中插入元素O(logn)--【可参考算法专栏28节】
* 【空间复杂度】O(k)--构建优先级队列，容量为k，缓存k值，故为k+1，即O(k)
 */
class KthLargest {
	PriorityQueue<Integer> q ;//容量为k的小顶堆
	int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.q=new PriorityQueue<Integer>(k);
    	for (int i : nums) {
			add(i);//将初始元素添加入小顶堆
		}
    }
    
    public int add(int val) {
    	if(q.size()<k){
    		//如果堆没满，直接添加
    		q.add(val);
    	}else if(val>q.peek()){
    		//如果堆满了且新入值比原第k大元素大，则移除堆顶元素（原第k大元素），然后新元素入堆
    		q.poll();
    		q.add(val);
    	}
    	return q.peek();//返回堆顶元素（新的第k大元素）
    }
}