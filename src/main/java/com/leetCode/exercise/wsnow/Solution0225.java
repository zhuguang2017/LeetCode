package com.leetCode.exercise.wsnow;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/**
* @author 白雪红叶约  2019.05.27
* 【题目】225. 用队列实现栈
* 【思路】 两个队列循环交替使用实现
* 		1.入栈，一律均入queue1队列中。
* 		2.出栈，queue1队列为空直接返回，非空则保留最后一个元素，将其前面入队元素均添加入queue2中，
* 然后交换queue1，queue2，将原queue1队列中最后一个元素出队返回。
* 		3.查看栈顶元素：queue1队列为空直接返回，非空则保留最后一个元素，将其前面入队元素均删除后添加入queue2中，
* 最后一个元素不删除添加入原queue2队列。然后交换queue1，queue2，并将原queue1最后一个元素删除并返回。
* 		4.为空判断：判断两队列是否均为空。
* 【时间复杂度】O(1|n)--入栈，判空为1，出栈以及查看栈顶元素为n
* 【空间复杂度】O(n)--两个队列实现一个栈，每个最长均为n，故2n空间复杂度
 */
class MyStack {
	
	Queue<Integer> queue1=new LinkedList<Integer>();
	Queue<Integer> queue2=new LinkedList<Integer>();

    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** 入栈，一律均入queue1队列中 */
    public void push(int x) {
    	queue1.add(x);
    }
    
    /** 出栈，queue1队列为空直接返回，非空则保留最后一个元素，将其前面入队元素均添加入queue2中，
     * 然后交换queue1，queue2，将原queue1队列中最后一个元素出队返回。 */
    public int pop() {
    	//如果队列为空，直接返回（题目中为int,不考虑空情况，故而返回-1标识表示）
    	if(queue1.size()==0)return -1;
        while(queue1.size()>1){
        	queue2.add(queue1.remove());//原1队列元素添加入2队列，留最后一个元素不动。
        }
        //交换12队列
        Queue<Integer> tmp=queue1;
        queue1=queue2;
        queue2=tmp;
        //将原queue1队列最后一个元素出队返回
        return queue2.remove();
    }
    
    /** 3.查看栈顶元素：queue1队列为空直接返回，非空则保留最后一个元素，将其前面入队元素均删除后添加入queue2中，
     * 最后一个元素不删除添加入原queue2队列。然后交换queue1，queue2，并将原queue1最后一个元素删除并返回。*/
    public int top() {
    	//如果队列为空，直接返回（题目中为int,不考虑空情况，故而返回-1标识表示）
    	if(queue1.size()==0)return -1;
        while(queue1.size()>1){
        	queue2.add(queue1.remove());//原1队列元素添加入2队列，留最后一个元素不动。
        }
        //最后一个元素添加至2队列，并不删除
        queue2.add(queue1.peek());
        //交换12队列
        Queue<Integer> tmp=queue1;
        queue1=queue2;
        queue2=tmp;
        //将原queue1队列最后一个元素出队返回
        return queue2.remove();
    }
    
    /** 为空判断：判断两队列是否均为空。 */
    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}

