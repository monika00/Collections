package Collections_Int;

//A HashMap contains values based on the key. It implements the Map interface and extends AbstractMap class
//It contains only unique elements
//It may have one null key and multiple null values
//It maintains no order

import java.util.*;

public class HashMap_exp {

	public static void main(String[] args) {
	
		HashMap<Integer,String> hm = new HashMap<Integer, String>();
		hm.put(100,"aaa");
		hm.put(101, "aaa");
		hm.put(102, "bbb");
		hm.put(103, "ccc");
		
		for(Map.Entry m :hm.entrySet()){
			System.out.println(m.getKey() +"  "+m.getValue());
		}

	}

}
