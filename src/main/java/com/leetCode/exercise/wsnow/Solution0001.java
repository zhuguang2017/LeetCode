package com.leetCode.exercise.wsnow;

import java.util.HashMap;
import java.util.Map;

public class Solution0001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> cache=new HashMap<Integer,Integer>();
    	for (int i = 0; i < nums.length; i++) {
    		if(cache.containsKey(target-nums[i])){
    			return new int[] {cache.get(target-nums[i]),i};
    		}
			cache.put(nums[i], i);
		}
    	return new int[] {};
        
    }
}
