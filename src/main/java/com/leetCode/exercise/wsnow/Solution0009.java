package com.leetCode.exercise.wsnow;

public class Solution0009 {

	public boolean isPalindrome(int x) {
		if(x<0)return false;
		if(x<10)return true;
		
		int res=0;
		while(x > res){
			res=res*10+x%10;
			x=x/10;
		}
		
		return (res==x)||(res/10==x);
    }
}
