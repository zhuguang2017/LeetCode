package com.leetCode.exercise.wsnow;

public class Solution0007 {

    public static int reverse(int x) {
    	int s=0;
    	while(x!=0){
    		int p=x%10;
    		x=x/10;
    		if(s>Integer.MAX_VALUE/10||(s==Integer.MAX_VALUE/10&&p>7))return 0;
    		if(s<Integer.MIN_VALUE/10||(s==Integer.MIN_VALUE/10&&p<-8))return 0;
    		s=s*10+p;
    	}
		return s;
        
    }
    
    public static void main(String[] args) {
		System.out.println(reverse(0x7fffffff));
		System.out.println(reverse(-1463847412));
	}
}
