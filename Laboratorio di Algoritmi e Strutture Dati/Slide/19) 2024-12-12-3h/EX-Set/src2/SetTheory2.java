import java.util.*;

public class SetTheory2 {
	

	public static <T> Set<T> union(Set<T> s1, Set<T> s2) {
		Set<T> r = new TreeSet<T>();  //scelta della classe obbligata
		r.addAll(s1);
		r.addAll(s2);
		return r;
	}

	public static <T> Set<T> intersection(Set<T> s1, Set<T> s2) {
		Set<T> r = new TreeSet<T>();
		r.addAll(s1);
		r.retainAll(s2);
		return r;
	}

	public static <T> Set<T> difference(Set<T> s1, Set<T> s2) {
		Set<T> r = new TreeSet<T>();
		r.addAll(s1);
		r.removeAll(s2);
		return r;
	}

	public static Set<Integer> abs(Set<Integer> s) {
		Set<Integer> r = new TreeSet<Integer>();
		for (int i : s)
			r.add(Math.abs(i));
		return r;
	}

	public static void main(String[] args) {
		final Integer[] aArray = { 1, -2, 3, -4 };
		final Integer[] bArray = { 1, 5, -6, -4 };

		Set<Integer> a = new HashSet<Integer>(Arrays.asList(aArray));
		Set<Integer> b = new HashSet<Integer>(Arrays.asList(bArray));
		Set<Integer> r;
		System.out.println("HashSet");
		System.out.println(" set A             = " + a);
		System.out.println(" set B             = " + b);
		r=SetTheory2.<Integer>union(a, b);
		System.out.println(" Union(A,B)        = " + r);
		r=SetTheory2.<Integer>intersection(a, b);
		System.out.println(" Intersection(A,B) = " + r);
		r=SetTheory2.<Integer>difference(a, b);
		System.out.println(" Difference(A,B)   = " + r);
		r=SetTheory2.abs(a);
		System.out.println(" Abs(A)            = " + r);
		System.out.println();

		a = new TreeSet<Integer>(Arrays.asList(aArray));
		b = new TreeSet<Integer>(Arrays.asList(bArray));
		r = new TreeSet<Integer>();
		System.out.println("TreeSet");
		System.out.println(" set A             = " + a);
		System.out.println(" set B             = " + b);
		r=SetTheory2.<Integer>union(a, b);
		System.out.println(" Union(A,B)        = " + r);
		r=SetTheory2.<Integer>intersection(a, b);
		System.out.println(" Intersection(A,B) = " + r);
		r=SetTheory2.<Integer>difference(a, b);
		System.out.println(" Difference(A,B)   = " + r);
		r=SetTheory2.abs(a);
		System.out.println(" Abs(A)            = " + r);
		System.out.println();
	}
}
