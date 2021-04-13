package questao1;

import models.BinarySearchTree;

public class Questao1 {
	
	public static void main (String [] args) {
		
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.insert("h");
		tree.insert("u");
		tree.insert("x");
		tree.insert("w");
		tree.insert("b");
		tree.insert("c");
		tree.insert("a");
		
		System.out.println(tree.toString());
	}

}
