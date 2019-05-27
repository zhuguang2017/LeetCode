package com.leetCode.exercise.wsnow;

import java.util.Stack;

public class Solution0232 {
	
	
	public static void main(String[] args) {
		 MyQueue obj = new MyQueue();
		 obj.push(1);
		 int param_2 = obj.pop();
		 int param_3 = obj.peek();
		 boolean param_4 = obj.empty();
		 System.out.println(param_2+""+param_3+""+param_4);
	}
	
	
}


/**
* @author 白雪红叶约  2019.05.27
* 【题目】232. 用栈实现队列
* 【思路】 两个栈交替使用实现
* 		1.入队，一律均入在in栈中。
* 		2.出队，out栈非空，直接出；out栈为空，in栈为空返回空；out栈为空，in栈不为空，将in栈逐个出栈并装入out栈，然后出。
* 		3.查看队首元素：out非空直接返回，out为空，将in栈逐个出栈并装入out栈，然后返回，元素或空。
* 		4.为空判断：判断两栈是否均为空。
* 【时间复杂度】O(1|n)--入队，判空为1，出队以及查看队头元素为n
* 【空间复杂度】O(n)--两个栈实现一个队列，每个最长均为n，故2n空间复杂度
 */
class MyQueue {

	Stack<Integer> inputStack = new Stack<Integer>();
	Stack<Integer> outStack = new Stack<Integer>();
	
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** 入队，一律均入在in栈中。 */
    public void push(int x) {
    	inputStack.push(x);
    }
    
    /** 出队，out栈非空，直接出；out栈为空，in栈为空返回空；out栈为空，in栈不为空，将in栈逐个出栈并装入out栈，然后出。 */
    public int pop() {
        if(!outStack.isEmpty()){
        	//out栈非空，直接出栈
        	return outStack.pop();
        }else{
        	if(inputStack.isEmpty()){
        		//返回空值（题目中为int,不考虑空情况，故而返回-1标识表示）
        		return -1;
        	}else{
        		while(!inputStack.isEmpty()){
        			outStack.push(inputStack.pop());
        		}
        		return outStack.pop();
        	}
        }
    }
    
    /** 查看队首元素：out非空直接返回，out为空，将in栈逐个出栈并装入out栈，然后返回，元素或空。 */
    public int peek() {
        if(!outStack.isEmpty()){
        	return outStack.peek();
        }else{
        	while(!inputStack.isEmpty()){
    			outStack.push(inputStack.pop());
    		}
        	//若仍为空，则返回空值（题目中为int,不考虑空情况，故而返回-1标识表示），否则返回出栈栈顶元素
    		return outStack.isEmpty()?-1:outStack.peek();
        }
    }
    
    /** 为空判断：判断两栈是否均为空。 */
    public boolean empty() {
    	return inputStack.isEmpty()&&outStack.isEmpty();
    }
}