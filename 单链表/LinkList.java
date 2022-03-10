package datas;

/**
 * 
 * 带头结点的单链表及其基本操作
 * 
 */
import java.util.Scanner;

public class LinkList implements IList {
	public Node head;// 单链表的头指针

	// 单链表的构造函数
	public LinkList() {
		head = new Node(); // 初始化头结点
	}

	public LinkList(int n, boolean Order) throws Exception {
		this();// 初始化头结点
		if (Order) // 用尾插法顺序建立单链表
			create1(n);
		else
			// 用头插法逆位序建立单链表
			create2(n);
	}

	// 用尾插法顺序建立单链表。其中n为该单链表的元素个数
	public void create1(int n) throws Exception {
		Scanner sc = new Scanner(System.in);// 构造用于输入的对象
		for (int j = 0; j < n; j++)
			// 输入n个元素的值
			insert(length(), sc.next());// 生成新结点,插入到表尾
	}

	// 用头插法逆位序建立单链表。其中n为该单链表的元素个数
	public void create2(int n) throws Exception {
		Scanner sc = new Scanner(System.in);// 构造用于输入的对象
		for (int j = 0; j < n; j++)
			// 输入n个元素的值
			insert(0, sc.next());// 生成新结点,插入到表头
	}

	// 将一个已经存在的带头结点单链表置成空表
	public void clear() {
		head.data=null;
		head.next=null;
	}

	// 判断当前带头结点的单链表是否为空
	public boolean isEmpty() {
		return head.next == null;// 判断首结点是否为空
	}

	// 求带头结点单链表中的数据元素个数并由函数返回其值
	public int length() {
		Node p = head.next;// 初始化,p指向首结点,length为计数器
		int length = 0;
		while (p != null) {// 从首结点向后查找，直到p为空
			p = p.next;// 指向后继结点
			++length;// 长度增1
		}
		return length;
	}

	// 读取带头结点单链表中的第i个数据元素
	public Object get(int i) throws Exception {
		Node p = head.next;// 初始化,p指向首结点,j为计数器
		int j = 0;
		while (p != null && j < i) {// 从首结点向后查找，直到p指向第i个元素或p为空
			p = p.next;// 指向后继结点
			++j;// 计数器的值增1
		}
		if (j > i || p == null) { // i小于0或者大于表长减1
			throw new Exception("第" + i + "个元素不存在");// 输出异常
		}
		return p.data;// 返回元素p
	}

	// 在带头结点单链表中第i个数据元素之前插入一个值为x的数据元素
	public void insert(int i, Object x) throws Exception {
		Node p = head;// 初始化p为头结点,j为计数器
		int j = -1; // 第i个结点前驱的位置
		while (p != null && j < i - 1) {// 寻找i个结点的前驱
			p = p.next;
			++j;// 计数器的值增1
		}
		if (j > i - 1 || p == null) // i不合法
			throw new Exception("插入位置不合理");// 输出异常

		Node s = new Node(x); // 生成新结点
		s.next=p.next;// 插入单链表中
		p.next=s;
	}

	// 将线性表中第i个数据元素删除。其中i取值范围为：0≤i≤length()- 1,如果i值不在此范围则抛出异常
	public void remove(int i) throws Exception {
		Node p = head;// p指向要删除结点的前驱结点
		int j = -1;
		while (p.next != null && j < i - 1) {// 寻找i个结点的前驱
			p = p.next;
			++j;// 计数器的值增1
		}
		if (j > i - 1 || p.next == null) { // i小于0或者大于表长减1
			throw new Exception("删除位置不合理");// 输出异常
		}
		p.next=p.next.next;// 删除结点
	}

	// 在带头结点的单链表中查找值为x的元素，如果找到，则函数返回该元素在线性表中的位置，否则返回-1
	public int indexOf(Object x) {
		Node p = head.next;// 初始化,p指向首结点,j为计数器
		int j = 0;
		while (p != null && !p.data.equals(x)) {// 从单链表中的首结点元素开始查找，直到p.data指向元素x或到达单链表的表尾
			p = p.next;// 指向下一个元素
			++j;// 计数器的值增1
		}
		if (p != null)// 如果p指向表中的某一元素
			return j;// 返回x元素在顺序表中的位置
		else
			return -1;// x元素不在顺序表中
	}


	// 输出线性表中的数据元素
	public void display() {
		Node node = head.next;// 取出带头结点的单链表中的首结点元素
		while (node != null) {
			System.out.print(node.data + " ");// 输出数据元素的值
			node = node.next;// 取下一个结点
		}
		System.out.println();
	}
	
}
