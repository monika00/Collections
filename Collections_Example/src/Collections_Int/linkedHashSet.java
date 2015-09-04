package Collections_Int;

//contains unique elements only like HashSet. It extends HashSet class and implements Set interface
//maintains insertion order.

import java.util.*;

public class linkedHashSet {

	public static void main(String[] args) {
		
		LinkedHashSet<String> lh = new LinkedHashSet<String>();
		lh.add("aaa");
		lh.add("aaa");
		lh.add("bbb");
		lh.add("ccc");
		
		Iterator<String> itr = lh.iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next());
		}

	}

}
