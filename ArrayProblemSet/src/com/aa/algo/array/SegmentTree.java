package com.aa.algo.array;

public class SegmentTree {
	
	int [] arr; 
	int len;
	int [] tree;
	
	public SegmentTree(int[] arr) {
		super();
		this.arr = arr;
		this.len = this.arr.length;
		
	}
	
	public void buildTree() {
		if(len > 0) {
			initializeTree();
			int currTreeNode=0;		
			buildTreeUtil(currTreeNode,0,len-1);							
		}				
	}

	private void initializeTree() {		
		tree = new int[4*len];
	}

	private int buildTreeUtil(int currTreeNode, int startIndex, int endIndex) {
		
		if(startIndex == endIndex) {
			tree[currTreeNode] = this.arr[startIndex];
			return tree[currTreeNode];
		}
		int mid = startIndex + (endIndex-startIndex)/2;
		tree[currTreeNode]= buildTreeUtil(2*currTreeNode+1, startIndex,mid) + buildTreeUtil(2*currTreeNode+2,mid+1,endIndex);
		return tree[currTreeNode];
	}
	
	public void printSegmentTree() {
		for(int i = 0 ; i< tree.length  ;i++)
			System.out.print(tree[i] + " ");
	}
	
	public static void main(String args[]) {
		int [] a = {1,2,3,4,5};
		SegmentTree tree = new SegmentTree(a);
		tree.buildTree();
		tree.printSegmentTree();
		
	}

}
