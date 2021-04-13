package models;

import java.util.ArrayList;
import java.util.List;

public class ElementIterative<T> {
public static void main(String [] args) {
		
		ElementIterative<Integer> city1 = new ElementIterative<>(1);
		ElementIterative<Integer> city2 = new ElementIterative<>(2);
		ElementIterative<Integer> city3 = new ElementIterative<>(3);
		
		city1.getRepresentative();
		
	}

	protected T ElementIterative;
	
	protected List <ElementIterative<T>> representative;
	
	public ElementIterative(T ElementIterative) {
		this.ElementIterative = ElementIterative;
		representative = new ArrayList<>();
		representative.add(this);
	}

	public ElementIterative<T> getRepresentative() {
		return representative.get(0);
	}

	public T getValue() {
		return ElementIterative;
	}
	
	public String toString() {
		return ElementIterative.toString();
	}
	
	public boolean inSameSet(ElementIterative<T> b) {
		return this.getRepresentative() == b.getRepresentative();
	}

	public void unionElementIteratives(ElementIterative<T> b) {
		ElementIterative<T> min = this.getRepresentative();
		for (ElementIterative<T> e : b.representative) {
			if (!this.representative.contains(e)) {
				this.representative.add(e);
				if (e.hashCode() < min.hashCode()) {
					min = e;
				}
			}
		}
		this.representative.remove(min);
		this.representative.add(0, min);
		b.representative = this.representative;
	}

}
