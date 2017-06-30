package com.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode508 {
static Map<Integer,Integer>sumToCount;
static int maxCount;
public static class TreeNode {
    int val;
    TreeNode left;
   TreeNode right;
    TreeNode(int x) { val = x; }
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,1,1,2,2,3};
		int[] b={0,5,9};
		int[] c={-4,-3,-2,5};
		System.out.println(removeDuplicates(a));
		System.out.println(summaryRanges(b));
		System.out.println(maxProduct(c));
	}
	 public int[] findFrequentTreeSum(TreeNode root) {
		 maxCount=0;
		 sumToCount=new HashMap<Integer, Integer>();
		 postOrder(root);
		  List<Integer> res = new ArrayList<Integer>();
	        for (int key : sumToCount.keySet()) {
	            if (sumToCount.get(key) == maxCount) {
	                res.add(key);
	            }
	        }
	        
	        int[] result = new int[res.size()];
	        for (int i = 0; i < res.size(); i++) {
	            result[i] = res.get(i);
	        }
	        return result;
	 }
	 public static int  postOrder(TreeNode root){
		 if(root==null)return 0;
		int left= postOrder(root.left);
		int right= postOrder(root.right);
		int sum=left+right+root.val;
		int count=sumToCount.getOrDefault(sum, 0)+1;
		sumToCount.put(sum, count);
		maxCount=Math.max(count, maxCount);
		return sum;
	 }
	 
	 public static int removeDuplicates(int[] nums) {
		 int i = 0;
		 //有重复的数字时  不会执行nums[i++] = n; 
		    for (int n : nums)
		        if (i < 2 || n > nums[i-2])
		            nums[i++] = n;
		    return i;
	        
	    }
	 public static List<String> summaryRanges(int[] nums) {
	        List<String>list=new  ArrayList<String>();
	        if(nums.length==0) return list;
	        if(nums.length==1){
	        	list.add(String.valueOf(nums[0]));
	        	return list;
	        }
	        if(nums.length==2){
	        	int b=nums[0]+1;
	        	if(nums[1]==b){
	        	list.add(String.valueOf(nums[0])+"->"+String.valueOf(nums[1]));
	        	return list;
	        	}
	        	else{
	        		list.add(String.valueOf(nums[0]));
		        	list.add(String.valueOf(nums[1]));
		        	return list;
	        	}
	        }
	     
	        int a=nums[0];
	        int b=a+1;
	        for(int i=1;i<nums.length;i++){
	        	if(nums[i]==b){
	        		b++;
	        	}
	        	else{
	        		if(a==b-1){
	        			list.add(String.valueOf(a));
	        		}
	        		else{
	        		list.add(String.valueOf(a)+"->"+String.valueOf(b-1));
	        		}
	        		a=nums[i];
	        		b=nums[i]+1;  
	        		if(i==nums.length-1)list.add(String.valueOf(a));
	        	}        
	        }
	        if(a!=b-1)
	    	list.add(String.valueOf(a)+"->"+String.valueOf(b-1));
	        return list;
	    }
	 public static List<String> summaryRanges1(int[] nums) {
	 List<String> list=new ArrayList();
		if(nums.length==1){
			list.add(nums[0]+"");
			return list;
		}
	    for(int i=0;i<nums.length;i++){
	    	int a=nums[i];
	    	while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
	    		i++;
	    	}
	    	if(a!=nums[i]){
	    		list.add(a+"->"+nums[i]);
	    	}else{
	    		list.add(a+"");
	    	}
	    }
	    return list;
	 }
	 
	 public static int maxProduct(int[] nums) {
		 List<Integer> list=new ArrayList();
		 if(nums.length==1){
			 return nums[0];
		 }
		 int max=Integer.MIN_VALUE;
		   for(int i=0;i<nums.length;i++){
			   int a=nums[i];
			   int j=0;
			   max=Math.max(max, a);
			   while(i+1<nums.length&&((nums[i+1]-nums[i])==1)){
				   i++;
				   a=a*nums[i];
				   max=Math.max(max, max*nums[i]);
			   }
			   while(i+1<nums.length&&((nums[i+1]-nums[i])==0)){
				   i++;
				   j++;
				   max=Math.max(max, a*nums[i]);
			   }
				if(a!=nums[i]){
		    		list.add(a*nums[i]);
		    		max=Math.max(max, a*nums[i]);
		    	}else{
		    		if(j!=0){
		    			list.add(a*nums[j]);
		    			max=Math.max(max, a*nums[j]);
		    		}
		    		list.add(a);
		    		max=Math.max(max, a);
		    	}
		   }
		   return max;
		 
	    }
}
