package com.leetCode.exercise.wsnow;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1046 {
	/**
	 * @author 白雪红叶约  2019.05.30
	 * 【题目】1046. 最后一块石头的重量
	 * 【思路】 优先级队列实现，维持一个石头数组长度个元素的大顶堆，石头全部入堆，每次取最大两个比较，若一样全抛弃，若不一样轧差后入堆
	 * 循环直至堆中对象小于等于1，若等于1返回对象，若小于1则返回0
	 * 【时间复杂度】O(nlogn)--插入为堆中插入元素O(logn),初始化n个元素插入为O(nlogn),循环为n/2-n，
	 * 【空间复杂度】O(n)--构建优先级队列，容量为数组长度n，即O(n)
	 */
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(stones.length, new Comparator<Integer>() { // 大顶堆，容量为数组长度
			@Override
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		});// 构建大顶堆
		for (Integer a : stones) {
			maxHeap.add(a);
		}

		while (maxHeap.size() > 1) {
			int p = maxHeap.remove();
			int q = maxHeap.remove();
			if (p != q) {
				maxHeap.add(p - q);
			} else {
				continue;
			}
		}
		return maxHeap.size() == 1 ? maxHeap.peek() : 0;
	}
}
