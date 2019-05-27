package com.leetCode.exercise.wsnow;

import java.util.Stack;

public class Solution0020 {

	/**
	* @author 白雪红叶约  2019.05.27
	* 【题目】20. 有效的括号
	* 【思路】转换为字符数组，逐个进行匹配判断，利用栈的后进先出特性，进行临近括号匹配消除。
	* 		1.先判断是否为括号符号，如果不是直接遍历下一个
	* 		2.进行符号匹配，如果栈非空，且有相匹配项则出栈，不匹配则说明是左括号，进行入栈
	* 		3.最后栈为空时候则说明表达式有效
	* 【时间复杂度】O(n)--一遍for循环，内部均普通语句故而为n
	* 【空间复杂度】O(n)--toCharArray() copy了一份数组 ，stack栈最深为n，故2n
	* @param s  
	* @return boolean true-  false-
	 */
	public static  boolean isValid(String s) {
		char[] arr=s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (Character c : arr) {
			if("{}[]()".contains(c.toString())){
				if(stack.size()!=0&&(('}'==c&&'{'==stack.peek())
					||(']'==c&&'['==stack.peek())||(')'==c&&'('==stack.peek()))){
					stack.pop();
				}else{
					stack.push(c);
				}
			}else{
				continue;
			}
		}
		return stack.size()==0;
    }
	
	
	public static  boolean isValid1(String s) {
		String a=s.replace("{}", "").replaceAll("[]", "").replaceAll("()", "");
		return a.contains("{");
    }
	
	
	public static void main(String[] args) {
		System.out.println(isValid("123456"));
		System.out.println(isValid("1()25)"));
		System.out.println(isValid("1()25{}"));
		System.out.println(isValid("{1(})25"));
	}

}
