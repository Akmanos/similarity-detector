package sets;

import java.util.HashSet;
import java.util.Set;

public class SetUtilities {
	/**
	 * Returns a new set representing the union of s and t.
	 * 
	 * Does not modify s or t.
	 * @param s
	 * @param t
	 * @return a new set representing the union of s and t
	 */
	public static <E> Set<E> union(Set<E> s, Set<E> t) {
		Set<E> n=new HashSet<E>();
		if(!s.isEmpty() && !t.isEmpty()) {
			n.addAll(t);
			n.addAll(s);
		}
		return n;
	}

	/**
	 * Returns a new set representing the intersection of s and t.
	 * 
	 * Does not modify s or t.
	 * @param s
	 * @param t
	 * @return a new set representing the intersection of s and t
	 */
	public static <E> Set<E> intersection(Set<E> s, Set<E> t) {
		Set<E> n=new HashSet<E>();
		
		if(!s.isEmpty() && !t.isEmpty()) {
			n=s;
			n.retainAll(t);		
		}
		return n;
	}

	/**
	 * Returns a new set representing the set difference s and t,
	 * that is, s \ t.
	 * 
	 * Does not modify s or t.
	 * @param s
	 * @param t
	 * @return a new set representing the difference of s and t
	 */
	public static <E> Set<E> setDifference(Set<E> s, Set<E> t) {
		Set<E> n= new HashSet<E>();
		if(!s.isEmpty() && !t.isEmpty()) {
			n.addAll(s);
			n.removeAll(t);
		}
		return n;
	}
	
	   /**
     * Returns a new set representing the symmetric difference of s and t,
     * 
     * Does not modify s or t.
     * @param s
     * @param t
     * @return a new set representing the symmetric difference of s and t
     */
    public static <E> Set<E> symmetricDifference(Set<E> s, Set<E> t) {
    	Set<E> n= new HashSet<E>();
    	if(!s.isEmpty() && !t.isEmpty()) {
    		n.addAll(s);
    		n.removeAll(t);
    		Set<E> b=t;
    		b.removeAll(s);
    		n.addAll(b);
    	}
        return n;
    }
	
	/**
	 * Returns the Jaccard index of the two sets s and t.
	 * 
	 * It is defined as 1 if both sets are empty.
     *
	 * Otherwise, it is defined as the size of the intersection of the sets, 
	 * divided by the size of the union of the sets.
	 * 
	 * Does not modify s or t.
	 * 
	 * @param s
	 * @param t
	 * @return the Jaccard index of s and t
	 */
	public static <E> double jaccardIndex(Set<E> s, Set<E> t) {
		double num=1;
		
		if(s.isEmpty() || t.isEmpty()) {
			return 0;
		}
		
		else if(s.isEmpty() && t.isEmpty()) {
			return 1;
		}
		
		Set<E> n= intersection(s, t);
		Set<E> b= union(s, t);
		num=(double)(n.size())/(b.size());

		return num;
	}
}
