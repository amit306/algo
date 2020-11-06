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
	
	
	public int sumQuery(int qsIndex, int qeIndex) {
		int currNode=0;
		return sumQueryUtil(currNode,0,len-1,qsIndex,qeIndex);
		
	}
	
	private int sumQueryUtil(int currNode,int startIndex, int endIndex, int qsIndex, int qeIndex) {
		
		// out of range
		if(startIndex > qeIndex || endIndex < qsIndex) 
			return 0;
		// within range
		if(qsIndex <= startIndex && qeIndex >= endIndex) 
			return tree[currNode];
		//partial matching
		int mid = startIndex + (endIndex-startIndex)/2;
		return sumQueryUtil(2*currNode+1,startIndex,mid,qsIndex,qeIndex)+ sumQueryUtil(2*currNode+2,mid+1,endIndex,qsIndex,qeIndex);		
		
	}
	
	public void update(int index , int val) {
		int valDiff = val - arr[index];
		updateUtil(0,0,len-1,index,valDiff);
	}

	private void updateUtil(int nodeIndex, int startIndex,int endIndex,int index, int valDiff) {
		
		if(startIndex >  index || index > endIndex)
			return ;
		
		// change the current path node;
		tree[nodeIndex] =tree[nodeIndex]+valDiff;
		
		if(startIndex != endIndex) {
			int mid = startIndex + (endIndex-startIndex)/2;
			updateUtil(2*nodeIndex+1,startIndex,mid,index,valDiff);
			updateUtil(2*nodeIndex+2,mid+1,endIndex,index,valDiff);
		}		
	}

	public void printSegmentTree() {
		for(int i = 0 ; i< tree.length  ;i++)
			System.out.print(tree[i] + " ");
	}
	
	public static void main(String args[]) {
		int [] a = {1,2,0,0,3,4,0,5};
		SegmentTree tree = new SegmentTree(a);
		tree.buildTree();
		tree.printSegmentTree();
		System.out.println();
		System.out.println("sum query "  + tree.sumQuery(2,5));
		System.out.println("sum query "  + tree.sumQuery(2,3));	
		tree.update(3, 19);
		System.out.println("sum query "  + tree.sumQuery(2,3));	
	}

}
