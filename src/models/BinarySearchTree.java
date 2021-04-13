package models;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class BinarySearchTree <T extends Comparable<T>> implements Iterable<T>{
	
	protected Node<T> root;
	
	protected int position = 0;
	
	public boolean insert(T value) {
		if(root == null) {
			root = new Node<>(value);
			return true;
		} else {
			return insert(root, value);
		}
	}
	
	private boolean insert(Node<T> node, T value) {
		if(value.compareTo(node.value) > 0) {
			if(node.hasRight()) {
				return insert(node.right, value);
			} else {
				node.right = new Node<>(value);
			}
		} else if(value.compareTo(node.value) < 0) {
			if(node.hasLeft()) {
				return insert(node.left, value);
			} else {
				node.left = new Node<>(value);
			}
		} else {
			return false; // contains value
		}
		return true;
	}
	
	public boolean contains(T value) {
		return contains(root, value);
	}
	
	private boolean contains(Node<T> node, T value) {
		if(node == null) {
			return false;
		} else {
			if(node.value == value) {
				return true;
			} else if(value.compareTo(node.value) > 0) {
				return contains(node.right, value);
			} else if(value.compareTo(node.value) < 0){
				return contains(node.left, value);
			}
		}
		return false;
	}
	
	public boolean remove(T value) {
		return remove(root, null, value);
	}
	
	private boolean remove(Node<T> node, Node<T> parent, T value) {
		if(node == null) {
			return false;
		} else if(node.value == value) {
			if(node.isLeaf()) {
				updateChild(node, parent, null);
			} else if(node.hasLeft() && !node.hasRight()) {
				updateChild(node, parent, node.left);
			} else if(!node.hasLeft() && node.hasRight()) {
				updateChild(node, parent, node.right);
			} else {
				Node<T> child = node.right;
				if(!child.hasLeft()) {
					child.left = node.left;
					updateChild(node, parent, child);
				} else {
					Node<T> successor = removeSuccessor(child);
					successor.left = node.left;
					successor.right = node.right;
					updateChild(node, parent, successor);
				}
			}
		} else if(value.compareTo(node.value) > 0) {
			return remove(node.right, node, value);
		} else if(value.compareTo(node.value) < 0) {
			return remove(node.left, node, value);
		}
		return true;
	}
	
	private void updateChild(Node<T> node, Node<T> parent, Node<T> child) {
		if(parent == null) {
			root = child;
		} else if(node.value.compareTo(parent.value) > 0) {
			parent.right = child;
		} else if(node.value.compareTo(parent.value) < 0) {
			parent.left = child;
		}
	}
	
	protected Node<T> removeSuccessor(Node<T> node) {
		if(!node.left.hasLeft()) {
			Node<T> successor  = node.left;
			node.left = successor.right;
			return successor;
		} else {
			return removeSuccessor(node.left);
		}
	}
	
	public void levelOrder() {
		LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			Node<T> current = queue.removeFirst();
			if (current != null) {
				System.out.println(root);
				queue.addLast(current.left);
				queue.addLast(current.right);
			}
		}
	}
	
    @Override
    public String toString() {
        return toString(root, "", 0);
    }

    public String toString(Node<T> current, String tabs, int level) {
        if (current == null) {
            return "";
        }
        String str = toString(current.right, tabs + "\t", level + 1);
        str += String.format("%s%s [Level:%d]\n", tabs, current.value, level + 1);
        str += toString(current.left, tabs + "\t", level + 1);
        return str;
    }
    
    public void preOrder() {
    	Iterator<T> iterator = preOrderIterator();
    	while(iterator.hasNext()) {
    		System.out.println(iterator.next());
    	}
    }
	
	public Iterator<T> preOrderIterator() {
		
		Stack<Node<T>> elements = new Stack<>();
		elements.push(root);
		
		return new Iterator<T>() {
			private Node<T> node = root;
			
			public boolean hasNext() {
				return (node != null);
			}
						
			public T next() {		
				
				Node<T> current = elements.pop();
				
				if (current.right != null) {
	            	elements.push(current.right);
	            }
				
	            if (current.left != null) {
	            	elements.push(current.left);
	            }	
	            
	            if(elements.empty()) {
	            	node = null;
	            }
	            return current.value;
			}			
		};
	}

	@Override
	public Iterator<T> iterator() {
		return preOrderIterator();
	}
}
