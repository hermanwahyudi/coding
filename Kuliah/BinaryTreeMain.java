/**
  * @author Herman Wahyudi
  */

import java.io.DataInputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class BinaryTreeMain
{
	private BinaryTree obj;
	public BinaryTreeMain() {
		obj = new BinaryTree();
		obj.inputData();
		obj.print();
	}
	public static void main(String[] args) {
		new BinaryTreeMain();
	}
}

class BinaryTree
{
	private DataInputStream b;
	private BufferedWriter t;
	private int value, level = 0;
	private String father = "";
	private Node root;

	private class Node {
		public Node leftNode, rightNode;
		public int value;
		public Node(int value) {
			this.value = value;
		}
	}
	public BinaryTree() {
		b = new DataInputStream(System.in);
		t = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	public void inputData() {
		String[] input;
		boolean stop = false;
		try {
			System.out.print("root ");
			root = new Node(Integer.parseInt(b.readLine()));
			do {
				String str = b.readLine();
				if(str != null) {
					input = str.split(" ");
					if(input[0].equals("insert")) {
						insertValue(root, Integer.parseInt(input[1]));
					} else if(input[0].equals("search")) {
						searchValue(root, Integer.parseInt(input[1]));
					}
				} else {
					stop = true;
				}
			} while(!stop);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void searchValue(Node node, int value) throws IOException {
		if(value == node.value) {
			t.write("" + value + " ada di level " + level + ", " + father + "\n");
			level = 0;
		} else if(value < node.value) {
			level++;
			if(node.leftNode != null) {
				father = "Anak kiri dari " + node.value;
				searchValue(node.leftNode, value);
			} else {
				t.write(value + " tidak ada di Tree\n");
			}
		} else if(value > node.value) {
			level++;
			if(node.rightNode != null) {
				father = "Anak kanan dari " + node.value;
				searchValue(node.rightNode, value);
			} else {
				t.write(value + " tidak ada di Tree\n");
			}
		}
	}
	public void insertValue(Node node, int value) {
		if(value < node.value) {
			if(node.leftNode != null) {
				insertValue(node.leftNode, value);
			} else {
				node.leftNode = new Node(value);
			}
		} else if(value > node.value) {
			if(node.rightNode != null) {
				insertValue(node.rightNode, value);
			} else {
				node.rightNode = new Node(value);
			}
		}
	}
	public void printPreOrder(Node node) {
		if(node != null) {
			System.out.print(node.value + " ");
			printInOrder(node.leftNode);
			printInOrder(node.rightNode);
		}
	}
	public void printPostOrder(Node node) {
		if(node != null) {
			printInOrder(node.leftNode);
			printInOrder(node.rightNode);
			System.out.print(node.value + " ");
		}
	}
	public void printInOrder(Node node) {
		if(node != null) {
			printInOrder(node.leftNode);
			System.out.print(node.value + " ");
			printInOrder(node.rightNode);
		}
	}
	public void print() {
		try {
			t.flush();
			System.out.print("\nPreOrder -> ");
			printPreOrder(root); System.out.println();
			System.out.print("InOrder -> ");
			printInOrder(root); System.out.println();
			System.out.print("PostOrder -> ");
			printPostOrder(root); System.out.println();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}