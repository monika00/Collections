package Collections_Int;

//contains unique elements only like HashSet. The TreeSet class implements NavigableSet interface that extends the SortedSet interface
//maintains ascending order

import java.util.*;

public class TreeSet_exp {

	public static void main(String[] args) {
		
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("ccc");
		ts.add("bbb");
		ts.add("aaa");
		ts.add("aaa");
		
		Iterator<String> itr = ts.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}

	}

}
