package Collections_Int;

//A TreeMap contains values based on the key. It implements the NavigableMap interface and extends AbstractMap class
//It contains only unique elements
//It cannot have null key but can have multiple null values
//It is same as HashMap instead maintains ascending order.

import java.util.*;

public class TreeMap_exp {

	public static void main(String[] args) {
		
		TreeMap<Integer,String> tm = new TreeMap<Integer, String>();
		tm.put(103, "aaa");
		tm.put(100, "ccc");
		tm.put(102, "aaa");
		tm.put(101, "bbb");
		
		for(Map.Entry m : tm.entrySet()){
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}

}
