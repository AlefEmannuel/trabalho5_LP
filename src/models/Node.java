package models;

public class Node <T> {
	
	public T value;
	public int height;

	public Node<T> left;
	public Node<T> right;

	public Node(T value) {
		this.value = value;
		this.height = 1;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public void setChilds(Node<T> left, Node<T> right) {
		this.left = left;
		this.right = right;
	}
}
