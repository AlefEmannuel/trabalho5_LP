package questao3;

import models.BinarySearchTree;

public class Questao3 {
	
public static <T> void main (String [] args) {
		
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.insert("h");
		tree.insert("u");
		tree.insert("x");
		tree.insert("w");
		tree.insert("b");
		tree.insert("c");
		tree.insert("a");
		
		tree.iterator().forEachRemaining(t -> {
			System.out.print(t);
		});	
	}
}
