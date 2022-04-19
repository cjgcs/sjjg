package 数和二叉树;

public class Main1 {
	public BiTree createBiTree() {
		BiTreeNode d=new BiTreeNode('D');
		BiTreeNode k=new BiTreeNode('K');
		BiTreeNode h=new BiTreeNode('H');
		BiTreeNode c=new BiTreeNode('C',d,null);
		BiTreeNode g=new BiTreeNode('G',h,k);
		BiTreeNode b=new BiTreeNode('B',null,c);
		BiTreeNode f=new BiTreeNode('F',g,null);
		BiTreeNode e=new BiTreeNode('E',null,f);
		BiTreeNode a=new BiTreeNode('A',b,e);
		return new BiTree(a);
	}
	public static void main(String[] args) {
		Main1 main1=new Main1();
		BiTree biTree=main1.createBiTree();
		BiTreeNode root=biTree.getRoot();
		
		System.out.println("先根");
		biTree.preRootTraverse(root);
		System.out.println();
		
		System.out.println("中根");
		biTree.inRootTraverse(root);
		System.out.println();
		
		System.out.println("后根");
		biTree.postRootTraverse(root);
		System.out.println();
		
		System.out.println("层次");
		biTree.levelTraverse();
		System.out.println();
	}
}



class BiTreeNode {
	public Object data;// 缁撶偣鐨勬暟鎹厓绱�

	public BiTreeNode lchild, rchild; // 宸﹀彸瀛╁瓙

	public BiTreeNode() {// 鏋勯�犱竴涓┖缁撶偣
		this(null);
	}

	public BiTreeNode(Object data) {// 鏋勯�犱竴妫靛乏鍙冲瀛愪负绌虹殑缁撶偣
		this(data, null, null);
	}

	public BiTreeNode(Object data, BiTreeNode lchild, BiTreeNode rchild) {// 鏋勯�犱竴妫垫暟鎹厓绱犲拰宸﹀彸瀛╁瓙閮戒笉涓虹┖鐨勭粨鐐�
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

interface IQueue {
	public void clear(); // 将一个已经存在的队列置成空

	public boolean isEmpty(); // 测试队列是否为空

	public int length();// 求队列中的数据元素个数并由函数返回其值

	public Object peek();// 查看队列的头而不移除它，返回队列顶对象，如果此队列为空，则返回 null

	public Object poll();// 移除队列的头并作为此函数的值返回该对象，如果此队列为空，则返回 null

	public void offer(Object o) throws Exception;// 把指定的元素插入队列

	public void display();// 打印函数，打印所有队列中的元素(队列头到队列尾)

}

class Node {
	public Object data; // 瀛樻斁缁撶偣鍊�

	public Node next; // 鍚庣户缁撶偣鐨勫紩鐢�

	public Node() { // 鏃犲弬鏁版椂鐨勬瀯閫犲嚱鏁�
		this(null, null);
	}

	public Node(Object data) { // 鏋勯�犲�间负data鐨勭粨鐐�
		this(data, null);
	}

	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}
}



class LinkQueue implements IQueue {
	private Node front;// 闃熷ご鐨勫紩鐢�

	private Node rear;// 闃熷熬鐨勫紩鐢紝鎸囧悜闃熷熬鍏冪礌

	// 閾鹃槦鍒楃被鐨勬瀯閫犲嚱鏁�
	public LinkQueue() {
		front = rear = null;
	}

	// 灏嗕竴涓凡缁忓瓨鍦ㄧ殑闃熷垪缃垚绌�
	public void clear() {
		front = rear = null;

	}

	// 娴嬭瘯闃熷垪鏄惁涓虹┖
	public boolean isEmpty() {
		return front == null;
	}

	// 姹傞槦鍒椾腑鐨勬暟鎹厓绱犱釜鏁板苟鐢卞嚱鏁拌繑鍥炲叾鍊�
	public int length() {
		Node p = front;
		int length = 0;// 闃熷垪鐨勯暱搴�
		while (p != null) {// 涓�鐩存煡鎵惧埌闃熷熬
			p = p.next;
			++length;// 闀垮害澧�1
		}
		return length;
	}

	// 鎶婃寚瀹氱殑鍏冪礌鎻掑叆闃熷垪
	public void offer(Object o) {
		Node p = new Node(o);// 鍒濆鍖栨柊鐨勭粨鐐�
		if (front != null) {// 闃熷垪闈炵┖
			rear.next=p;
			rear = p;// 鏀瑰彉闃熷垪灏剧殑浣嶇疆
		} else
			// 闃熷垪涓虹┖
			front = rear = p;
	}

	// 鏌ョ湅闃熷垪鐨勫ご鑰屼笉绉婚櫎瀹冿紝杩斿洖闃熷垪椤跺璞★紝濡傛灉姝ら槦鍒椾负绌猴紝鍒欒繑鍥� null
	public Object peek() {
		if (front != null) // 闃熷垪闈炵┖
			return front.data;// 杩斿洖闃熷垪鍏冪礌
		else
			return null;
	}

	// 绉婚櫎闃熷垪鐨勫ご骞朵綔涓烘鍑芥暟鐨勫�艰繑鍥炶瀵硅薄锛屽鏋滄闃熷垪涓虹┖锛屽垯杩斿洖 null
	public Object poll() {
		if (front != null) { // 闃熷垪闈炵┖
			Node p = front;// p鎸囧悜闃熷垪澶寸粨鐐�
			front = front.next;
			if (p==rear)       //琚垹鐨勭粨鐐规槸闃熷熬缁撶偣
				rear=null;
			return p.data;// 杩斿洖闃熷垪澶寸粨鐐规暟鎹�
		} else
			return null;
	}

	// 鎵撳嵃鍑芥暟锛屾墦鍗版墍鏈夐槦鍒椾腑鐨勫厓绱�(闃熷垪澶村埌闃熷垪灏�)
	public void display() {
		if (!isEmpty()) {
			Node p = front;
			while (p != rear.next) {// 浠庡澶村埌闃熷熬
				System.out.print(p.data.toString() + " ");
				p = p.next;
			}
		} else {
			System.out.println("姝ら槦鍒椾负绌�");
		}
	}

}

