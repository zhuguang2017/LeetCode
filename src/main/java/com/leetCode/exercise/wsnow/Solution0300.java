package com.leetCode.exercise.wsnow;

public class Solution0300 {

	 public static int lengthOfLIS(int[] nums) {
		 	int[] dparr=new int[nums.length];
		 	int len=1;
		 	for (int i = 1; i < nums.length; i++) {
				if(nums[i]>nums[i-1]){
					len=len+1;
					dparr[i]=len;
				}else{
					len=1;
					dparr[i]=len;
				}
			}
		 	int max=0;
		 	for (int i = 0; i < dparr.length; i++) {
				if(max<dparr[i]){
					max=dparr[i];
				}
			}
	        return max;
	 }
	 
	 public static void main(String[] args) {
		 int[] nums={1,2,1,3,5,6,7,3,2};
		 System.out.println(lengthOfLIS(nums));
	}
	
}
