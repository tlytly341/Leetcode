package com.utils;

public class Leetcode623 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(4);
		TreeNode left=new TreeNode(2);
		TreeNode left1=new TreeNode(3);
		TreeNode left2=new TreeNode(1);
		root.left=left;
		root.right=null;
		root.left.left=left1;
		root.left.right=left2;
		System.out.print(addOneRow(root, 1, 3));
	}
	public static class TreeNode {
	    int val;
	    TreeNode left;
	   TreeNode right;
	    TreeNode(int x) { val = x; }
		
	}
	public static TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode newRoot = new TreeNode(v);
			newRoot.left = root;
			return newRoot;
		}
		add(root, v, d, 1);
		return root;
	}

	private static void add(TreeNode node, int v, int d, int currentDepth) {
		if (node == null) {
			return;
		}

		if (currentDepth == d - 1) {
			TreeNode temp = node.left;
			node.left = new TreeNode(v);
			node.left.left = temp;

			temp = node.right;
			node.right = new TreeNode(v);
			node.right.right = temp;
			return;
		}

		add(node.left, v, d, currentDepth + 1);
		add(node.right, v, d, currentDepth + 1);
	}


}
