package com.utils;

import java.util.ArrayDeque;

public class Leetcode513 {
	 public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int ans=0, h=0;
	  public int findBottomLeftValue(TreeNode root) {
	        findBottomLeftValue(root, 1);
	        return ans;
	    }
	    public void findBottomLeftValue(TreeNode root, int depth) {
	        if (h<depth) {ans=root.val;h=depth;}
	        if (root.left!=null) findBottomLeftValue(root.left, depth+1);
	        if (root.right!=null) findBottomLeftValue(root.right, depth+1);
	    }
	    public int findBottomLeftValuebfs(TreeNode root){
	    	int result=-1;
	    	ArrayDeque<TreeNode>queue=new ArrayDeque<TreeNode>();
	   queue.offer(root);
	   if(!queue.isEmpty()){
		   result=queue.peek().val;
		   int size=queue.size();
		   for(int i=0;i<size;i++){
			   TreeNode node=queue.poll();
			   if(node.left!=null){
				   queue.offer(node.left);
			   }
			   if(node.right!=null){
				   queue.offer(node.right);
			   }
		   }
	   }
	   return result;
	    }
}
