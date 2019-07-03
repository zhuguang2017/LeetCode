package com.leetCode.exercise.wsnow;

public class Solution0014 {
	  public String longestCommonPrefix(String[] strs) {
	        String pre=(strs.length==0?"":strs[0]);
			  for (int i = 0; i < strs.length; i++) {
				 while(strs[i].indexOf(pre)!=0){
					 pre=pre.substring(0, pre.length()-1);
					 if("".equals(pre))return "";
				 }
			  }
			  return pre;
	  }
}
