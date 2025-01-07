import java.util.*;

public class SetTheory {

	public static <T> void union(Set<T> s1, Set<T> s2, Set<T> r) {
		r.clear();
		r.addAll(s1);
		r.addAll(s2);
	}

	public static <T> void intersection(Set<T> s1, Set<T> s2, Set<T> r) {
		r.clear();
		r.addAll(s1);
		r.retainAll(s2); //Retains only the elements in r that are contained in s2
	}

	public static <T> void difference(Set<T> s1, Set<T> s2, Set<T> r) {
		r.clear();
		r.addAll(s1);
		r.removeAll(s2);
	}

	public  static void abs(Set<Integer> s, Set<Integer> r) {
		r.clear();
		for (int i : s)
			r.add(Math.abs(i));
	}

	public static void main(String[] args) {
		final Integer[] aArray = { 2, -2, 1, -4, -1 };
		final Integer[] bArray = { 1, 5, -6, -4 };

		Set<Integer> a = new HashSet<Integer>(Arrays.asList(aArray));
		Set<Integer> b = new HashSet<Integer>(Arrays.asList(bArray));
		Set<Integer> r = new HashSet<Integer>();
		System.out.println("HashSet");
		System.out.println(" set A             = " + a);
		System.out.println(" set B             = " + b);
		SetTheory.<Integer>union(a, b, r);
		System.out.println(" Union(A,B)        = " + r);
		SetTheory.<Integer>intersection(a, b, r);
		System.out.println(" Intersection(A,B) = " + r);
		SetTheory.<Integer>difference(a, b, r);
		System.out.println(" Difference(A,B)   = " + r);
		SetTheory.abs(a, r);
		System.out.println(" Abs(A)            = " + r);
		System.out.println();

		a = new TreeSet<Integer>(Arrays.asList(aArray));
		b = new TreeSet<Integer>(Arrays.asList(bArray));
		r = new TreeSet<Integer>();
		System.out.println("TreeSet");
		System.out.println(" set A             = " + a);
		System.out.println(" set B             = " + b);
		SetTheory.<Integer>union(a, b, r);
		System.out.println(" Union(A,B)        = " + r);
		SetTheory.<Integer>intersection(a, b, r);
		System.out.println(" Intersection(A,B) = " + r);
		SetTheory.<Integer>difference(a, b, r);
		System.out.println(" Difference(A,B)   = " + r);
		SetTheory.abs(a, r);
		System.out.println(" Abs(A)            = " + r);
		System.out.println();
	}
}
