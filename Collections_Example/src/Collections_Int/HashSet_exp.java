package Collections_Int;

//uses hashtable to store the elements.It extends AbstractSet class and implements Set interface
//contains unique elements only
//List can contain duplicate elements whereas Set contains unique elements only

import java.util.*;

public class HashSet_exp {

	public static void main(String[] args) {
		
		HashSet<String> h1 = new HashSet<String>();
		h1.add("aaa");
		h1.add("aaa");
		h1.add("bbb");
		h1.add("ccc");
		
		Iterator<String> itr = h1.iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
	}

}
