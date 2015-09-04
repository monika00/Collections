package Collections_Int;

//A Hashtable is an array of list.Each list is known as a bucket.The position of bucket is identified by calling the hashcode() method.A Hashtable contains values based on the key. It implements the Map interface and extends Dictionary class.
//It contains only unique elements
//It may have not have any null key or value
//It is synchronized

import java.util.*;

public class HashTable_exp {

	public static void main(String[] args) {
		
		Hashtable<Integer,String> ht = new Hashtable<Integer, String>();
		ht.put(108, "aaa");
		ht.put(100, "aaa");
		ht.put(101, "bbb");
		ht.put(102, "ccc");
		
		for(Map.Entry m : ht.entrySet()){
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}

}
