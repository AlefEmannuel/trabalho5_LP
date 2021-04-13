package models;

public class Set {
	
	public static void main(String [] args) {
		ElementIterative<Integer> city1 = new ElementIterative<>(1);
		ElementIterative<Integer> city2 = new ElementIterative<>(2);
		ElementIterative<Integer> city3 = new ElementIterative<>(3);
		
		boolean v = Set.inSameSet(city1, city2);
	}

	public static <T> boolean inSameSet(ElementIterative<T> a, ElementIterative<T> b) {
		return a.getRepresentative() == b.getRepresentative();
	}

	public static <T> void unionElementIteratives(ElementIterative<T> a, ElementIterative<T> b) {
		ElementIterative<T> min = a.getRepresentative();
		for (ElementIterative<T> e : b.representative) {
			if (!a.representative.contains(e)) {
				a.representative.add(e);
				if (e.hashCode() < min.hashCode()) {
					min = e;
				}
			}
		}
		a.representative.remove(min);
		a.representative.add(0, min);
		b.representative = a.representative;
	}

}
