package ch05;

/**
 * 
 *二叉链式存储结构下的二叉树
 * 
 */
import ch03.LinkQueue;
import ch03.LinkStack;

public class BiTree {

	private BiTreeNode root;// 树的根结点

	public BiTree() {// 构造一棵空树
		this.root = null;
	}

	public BiTree(BiTreeNode root) {// 构造一棵树
		this.root = root;
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



	// 层次遍历二叉树基本操作的算法(自左向右)
	public void levelTraverse() {
		BiTreeNode T = root;
		if (T != null) {
			LinkQueue L = new LinkQueue();// 构造队列
			L.offer(T);// 根结点入队列
			while (!L.isEmpty()) {
				T = (BiTreeNode) L.poll();
				System.out.print(T.data); // 访问结点
				if (T.lchild != null)// 左孩子非空，入队列
					L.offer(T.lchild);
				if (T.rchild != null)// 右孩子非空，入队列
					L.offer(T.rchild);
			}
		}

	}

	public BiTreeNode getRoot() {
		return root;
	}

	public void setRoot(BiTreeNode root) {
		this.root = root;
	}




}
