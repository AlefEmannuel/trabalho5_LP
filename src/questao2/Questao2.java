package questao2;

import java.util.Iterator;

import models.BinarySearchTree;

public class Questao2 {
	
	public static <T> void main (String [] args) {
		
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.insert("h");
		tree.insert("u");
		tree.insert("x");
		tree.insert("w");
		tree.insert("b");
		tree.insert("c");
		tree.insert("a");
		
		Iterator<String> iterator1 = tree.preOrderIterator();
		
		for(int i = 0; i < 5; i++)
			System.out.print(iterator1.next());
		
		System.out.println("");
		
		Iterator<String> iterator2 = tree.preOrderIterator();
		
		while(iterator2.hasNext())
			System.out.print(iterator2.next());
	}

}
