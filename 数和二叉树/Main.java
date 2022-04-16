package 数和二叉树;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner kb=new Scanner(System.in);
		String a=kb.next();
		String shunxu=a;
		BiTree X=new BiTree(shunxu);
		X.preRootTraverse(X.getRoot());
		System.out.println();
		X.inRootTraverse(X.getRoot());
		System.out.println();
		X.postRootTraverse(X.getRoot());
		System.out.println();
		System.out.println(X.countNode(X.getRoot()));
		System.out.println(X.countNode1(X.getRoot()));
	}

}

class BiTreeNode {
	public Object data;

	public BiTreeNode lchild, rchild; 

	public BiTreeNode() {
		this(null);
	}

	public BiTreeNode(Object data) {
		this(data, null, null);
	}

	public BiTreeNode(Object data, BiTreeNode lchild, BiTreeNode rchild) {
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}


}


class BiTree {

	private BiTreeNode root;// 树的根结点

	public BiTree() {// 构造一棵空树
		this.root = null;
	}

	public BiTree(BiTreeNode root) {// 构造一棵树
		this.root = root;
	}

	// 由标明空子树的先根遍历序列建立一棵二叉树
	private static int index = 0;// 用于记录preStr的索引值

	public BiTree(String preStr) {
		char c = preStr.charAt(index++);// 取出字符串索引为index的字符，且index增1
		if (c != '#') {// 字符不为#
			root = new BiTreeNode(c);// 建立树的根结点
			root.lchild=new BiTree(preStr).root;// 建立树的左子树
			root.rchild=new BiTree(preStr).root;// 建立树的右子树
		} else
			root = null;
	}



	// 先根遍历二叉树基本操作的递归算法
	public void preRootTraverse(BiTreeNode T) {
		if (T != null) {
			System.out.print(T.data); // 访问根结点
			preRootTraverse(T.lchild);// 访问左子树
			preRootTraverse(T.rchild);// 访问右子树
		}
	}



	// 中根遍历二叉树基本操作的递归算法
	public void inRootTraverse(BiTreeNode T) {
		if (T != null) {
			inRootTraverse(T.lchild);// 访问左子树
			System.out.print(T.data); // 访问根结点
			inRootTraverse(T.rchild);// 访问右子树
		}
	}



	// 后根遍历二叉树基本操作的递归算法
	public void postRootTraverse(BiTreeNode T) {
		if (T != null) {
			postRootTraverse(T.lchild);// 访问左子树
			postRootTraverse(T.rchild);// 访问右子树
			System.out.print(T.data); // 访问根结点
		}
	}
	
	public int countNode(BiTreeNode T) {
		int count=0;
		if(T !=null) {
			++count;
			count+=countNode(T.lchild);
			count+=countNode(T.rchild);
		}
		return count;
	}
	
	public int countNode1(BiTreeNode T) {
		int count=0;
		if(T !=null) {
			if(T.lchild==null && T.rchild==null) {
			++count;
		}
			count+=countNode1(T.lchild);
			count+=countNode1(T.rchild);
		}
		return count;
	}


	public BiTreeNode getRoot() {
		return root;
	}

	public void setRoot(BiTreeNode root) {
		this.root = root;
	}

}