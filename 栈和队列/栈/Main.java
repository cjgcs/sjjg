package 栈和队列;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner kb=new Scanner(System.in);
		SqStack X=new SqStack(100);
		int a=kb.nextInt();
		for(int i=0;i<a;i++) {
			int b=kb.nextInt();
			X.push(b);
		}
		X.display();
		int c=kb.nextInt();
		X.push(c);
		X.display();
		X.pop();
		System.out.println();
		X.display();
	}

}


interface IStack {
	public void clear(); 
	public boolean isEmpty(); 
	public int length();
	public Object peek();
	public Object pop();
	public void push(Object o) throws Exception;
	public void display();
}



class SqStack implements IStack {

	private Object[] stackElem; 

	private int top; 

	public SqStack(int maxSize) {
		top = 0; 
		stackElem = new Object[maxSize];
	}


	public void clear() {
		top = 0;
	}


	public boolean isEmpty() {
		return top == 0;
	}


	public int length() {
		return top;
	}


	public Object peek() {
		if (!isEmpty())
			return stackElem[top - 1]; 
		else
			
			return null;
	}

	public Object pop() {
		if (top == 0)
			return null;
		else {
			return stackElem[--top];
		}
	}


	public void push(Object o) throws Exception {
		if (top == stackElem.length)
			throw new Exception("鏍堝凡婊�");
		else
			
			stackElem[top++] = o;
	}


	public void display() {
		for (int i = top - 1; i >= 0; i--)
			System.out.print(stackElem[i].toString() + " ");
	}

}