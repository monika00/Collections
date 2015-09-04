package Collections_Int;

//A LinkedHashMap contains values based on the key. It implements the Map interface and extends HashMap class
//It contains only unique elements
//It may have one null key and multiple null values
//It is same as HashMap instead maintains insertion order.

import java.util.*;

public class LinkedHashMap_exp {

	public static void main(String[] args) {
		
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>();
		lhm.put(100,"ccc");
		lhm.put(101,"aaa");
		lhm.put(102, "aaa");
		lhm.put(103, "bbb");
		
		for(Map.Entry m : lhm.entrySet()){
			System.out.println(m.getKey() +" "+m.getValue());
		}


	}

}
